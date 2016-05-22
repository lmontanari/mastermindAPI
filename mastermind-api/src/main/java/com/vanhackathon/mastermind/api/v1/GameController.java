package com.vanhackathon.mastermind.api.v1;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vanhackathon.mastermind.api.dto.GameDTO;
import com.vanhackathon.mastermind.api.dto.GuessDTO;
import com.vanhackathon.mastermind.domain.Colors;
import com.vanhackathon.mastermind.exception.GameNotFoundException;
import com.vanhackathon.mastermind.exception.NotYourTurnException;
import com.vanhackathon.mastermind.service.GameService;

/**
 * Rest services to play games.
 * 
 * @author lmontanari (lucas_montanari@hotmail.com)
 */
@RestController
@RequestMapping("/v1")
public class GameController {

	private GameService gameService;

	@Autowired
	public GameController(GameService gameService) {
		this.gameService = gameService;
	}

	@RequestMapping(value = "/colors", method = RequestMethod.GET)
	public ResponseEntity<List<Colors>> getAllColors() {
		List<Colors> colors = Arrays.asList(Colors.values());
		return ResponseEntity.status(HttpStatus.OK).body(colors);
	}

	@RequestMapping(value = "/guess", method = RequestMethod.POST)
	public ResponseEntity<GameDTO> guess(@RequestBody GuessDTO guess) {
		GameDTO game = gameService.guess(guess);
		return ResponseEntity.status(HttpStatus.OK).body(game);
	}

	@RequestMapping(value = "/createGame", method = RequestMethod.POST)
	public ResponseEntity<GameDTO> createGame(@RequestBody(required = true) String username) {
		GameDTO gameDTO = gameService.newGame(username);
		return ResponseEntity.status(HttpStatus.CREATED).body(gameDTO);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public void handleIllegalArguments(HttpServletResponse response, Exception e) throws IOException {
		response.sendError(HttpStatus.BAD_REQUEST.value(), e.getMessage());
	}

	@ExceptionHandler(GameNotFoundException.class)
	public void handleGameNotFound(HttpServletResponse response, Exception e) throws IOException {
		response.sendError(HttpStatus.NOT_FOUND.value(), e.getMessage());
	}

	@ExceptionHandler(NotYourTurnException.class)
	public void handleNotYourTurn(HttpServletResponse response, Exception e) throws IOException {
		response.sendError(HttpStatus.CONFLICT.value(), e.getMessage());
	}
}
