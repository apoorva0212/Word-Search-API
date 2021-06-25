package com.game.wordsearchapi.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.game.wordsearchapi.services.WordGridService;

@RestController("/")
public class WordSearchController {
	
	@Autowired
	WordGridService wordGridService;
	
	@GetMapping("/wordgrid")
	public String createWordGrid(@RequestParam int gridSize, @RequestParam String wordList) {
		List<String> words = Arrays.asList(wordList.split(","));
		char[][] grid = wordGridService.fillGrid(gridSize, words);
		String gridToString = "";
		for(int i=0; i<gridSize; i++) {
			for(int j=0; j<gridSize; j++) {
				gridToString += grid[i][j] + " ";
			}
			gridToString += "\r\n";
		}
		return gridToString;
	}

}
