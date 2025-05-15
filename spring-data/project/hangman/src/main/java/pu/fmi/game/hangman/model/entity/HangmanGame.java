package pu.fmi.game.hangman.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "HANGMAN_GAME")
public class HangmanGame {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "GAME_ID", nullable = false)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "WORD_ID", referencedColumnName = "ID")
  private Word word;

  @Column(name = "STARTED_ON_DATE")
  private LocalDateTime startedOnDate;

  @Column(name="CURRENT_WORD", nullable = false, length = 100)
  private String currentWord;

  @Enumerated(EnumType.STRING)
  private Status status;

  @Column(name = "WRONG_LETTERS")
  private String wrongLetters;

  @Column(name = "WORD_GUESSES", nullable = false)
  private int wrongGuesses;

  @Column(name = "CURRENT_WRONG_GUESS", nullable = false)
  private int currentWrongGuess;

  @ManyToOne
  @JoinColumn(name = "PLAYER_ID", referencedColumnName = "ID")
  private Player player;

  
//Вместо Lombok, не работеше локално на компютъра ми и не можах да го инсталирам
  public HangmanGame() {
  }

  public HangmanGame(Long id, Word word, LocalDateTime startedOnDate, String currentWord, Status status,
                     String wrongLetters, int wrongGuesses, int currentWrongGuess, Player player) {
    this.id = id;
    this.word = word;
    this.startedOnDate = startedOnDate;
    this.currentWord = currentWord;
    this.status = status;
    this.wrongLetters = wrongLetters;
    this.wrongGuesses = wrongGuesses;
    this.currentWrongGuess = currentWrongGuess;
    this.player = player;
  }

  // Getters and setters

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Word getWord() {
    return word;
  }

  public void setWord(Word word) {
    this.word = word;
  }

  public LocalDateTime getStartedOnDate() {
    return startedOnDate;
  }

  public void setStartedOnDate(LocalDateTime startedOnDate) {
    this.startedOnDate = startedOnDate;
  }

  public String getCurrentWord() {
    return currentWord;
  }

  public void setCurrentWord(String currentWord) {
    this.currentWord = currentWord;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public List<String> getWrongLetters() {
    return wrongLetters == null || wrongLetters.isBlank()
        ? new ArrayList<>()
        : new ArrayList<>(Arrays.asList(wrongLetters.split(",")));
  }

  public void setWrongLetters(List<String> letters) {
    this.wrongLetters = String.join(",", letters);
  }

  public int getWrongGuesses() {
    return wrongGuesses;
  }

  public void setWrongGuesses(int wrongGuesses) {
    this.wrongGuesses = wrongGuesses;
  }

  public int getCurrentWrongGuess() {
    return currentWrongGuess;
  }

  public void setCurrentWrongGuess(int currentWrongGuess) {
    this.currentWrongGuess = currentWrongGuess;
  }

  public Player getPlayer() {
    return player;
  }

  public void setPlayer(Player player) {
    this.player = player;
  }

  // Optional: toString() method if искаш

  @Override
  public String toString() {
    return "HangmanGame{" +
        "id=" + id +
        ", word=" + word +
        ", startedOnDate=" + startedOnDate +
        ", currentWord='" + currentWord + '\'' +
        ", status=" + status +
        ", wrongLetters='" + wrongLetters + '\'' +
        ", wrongGuesses=" + wrongGuesses +
        ", currentWrongGuess=" + currentWrongGuess +
        ", player=" + player +
        '}';
  }
}
