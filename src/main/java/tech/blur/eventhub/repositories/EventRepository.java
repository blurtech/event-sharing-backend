package tech.blur.eventhub.repositories;

import tech.blur.eventhub.models.AssignEvent;
import tech.blur.eventhub.models.Event;

import java.util.ArrayList;
import java.util.Collection;

public interface EventRepository {

  Event fetchEvent(String id);

  Event updateEvent(Event event);

  ArrayList<Event> searchEvent(String name);

  ArrayList<Event> getEventsByUser(String host);

  ArrayList<Event> getAssignedEvents(String id);

  ArrayList<Event> getEventsByTag(String id);

  Event assignEvent (final AssignEvent assignEvent);

  void deleteEvent(String id);

  Event createEvent(Event event);

  Collection<Event> getAllEvents();
}