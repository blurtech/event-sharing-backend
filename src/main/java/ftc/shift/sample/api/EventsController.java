package ftc.shift.sample.api;


import ftc.shift.sample.models.Event;
import ftc.shift.sample.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class EventsController {

  private static final String EVENTS_PATH = Resources.API_PREFIX + "events";

  @Autowired
  private EventService service;

  @GetMapping(EVENTS_PATH + "/{id}")
  public @ResponseBody
  BaseResponse<Event> readEvent(@PathVariable String id) {
    BaseResponse<Event> response = new BaseResponse<>();
    Event event = service.provideEvent(id);

    if (null == event) {
      response.setStatus("EVENT_NOT_EXIST");  //для статусов  можно сделать отдельные Enum-ы или вынести как строковые константы
      response.setMessage("Event not found!");
    } else {
      response.setData(event);
    }
    return response;
  }

  @GetMapping(EVENTS_PATH)
  public @ResponseBody
  BaseResponse<Collection<Event>> listEvents() {
    BaseResponse<Collection<Event>> response = new BaseResponse<>();
    Collection<Event> result = service.provideEvents();
    response.setData(result);
    return response;
  }

  @PostMapping(EVENTS_PATH)
  public @ResponseBody
  BaseResponse<Event> createEvent(@RequestBody Event event) {
    BaseResponse<Event> response = new BaseResponse<>();
    Event result = service.createEvent(event);
    response.setData(result);
    return response;
  }

  @DeleteMapping(EVENTS_PATH + "/{id}")
  public @ResponseBody
  BaseResponse deleteEvent(@PathVariable String id) {
    service.deleteEvent(id);
    return new BaseResponse(); //нет тела, только статус
  }

  @PatchMapping(EVENTS_PATH + "/{id}")
  public @ResponseBody
  BaseResponse<Event> updateEvent(@PathVariable String id, @RequestBody Event event) {
    BaseResponse<Event> response = new BaseResponse<>();
    Event result = service.updateEvent(event);
    response.setData(result);
    return response;
  }

}