package spring.rest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.rest.dto.StoryDto;
import spring.rest.dto.StoryResponseDto;
import spring.rest.mapper.StoryMapper;
import spring.rest.service.StoryService;

@RestController
@RequestMapping("/api")
public class StoryController {

  final private StoryService storyService;

  public StoryController(StoryService storyService, StoryMapper storyMapper) {
    this.storyService = storyService;
  }

  @GetMapping("/stories")
  public List<StoryResponseDto> findAllStories() {

    return storyService.findAllStories();
  }

  @PostMapping("/stories")
  public StoryResponseDto createStory(@RequestBody StoryDto dto) {

    return storyService.createStory(dto);
  }

  @GetMapping("/stories/public")
  public List<StoryResponseDto> findAllPublicStories() {

    return storyService.findAllPublicStories();
  }

  @GetMapping("/stories/{id}")
  public StoryResponseDto findStoryById(@PathVariable Long id) {

    return storyService.findStoryById(id);
  }

}
