package pu.fmi.game.hangman.model.wordprovider;

import java.util.List;
import java.util.Random;
import pu.fmi.game.hangman.model.entity.Word;
import pu.fmi.game.hangman.model.repository.WordRepository;

public class WordProvider implements GenericWordProvider {

  private final List<String> wordsCollection = List.of("мерцедес", "шаблон", "ауди", "парк", "лаптоп");

  private final WordRepository wordRepository;

  // Конструктор без Lombok
  public WordProvider(WordRepository wordRepository) {
    this.wordRepository = wordRepository;
  }

  @Override
  public String generateRandomWord(){
    Random random = new Random();
    return this.wordsCollection.get(random.nextInt(this.wordsCollection.size()));
  }

  @Override
  public Word generateRandomWordFromDB(){
    Random random = new Random();
    List<Word> wordsCollection = wordRepository.findAll();
    return wordsCollection.get(random.nextInt(wordsCollection.size()));
  }
}
