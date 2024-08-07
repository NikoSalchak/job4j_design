package ru.job4j.ood.srp.formatter;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarAdapterJson implements JsonSerializer<Calendar>, JsonDeserializer<Calendar> {
    private static final ThreadLocal<DateFormat> DATE_FORMAT
            = ThreadLocal.withInitial(() -> new SimpleDateFormat("dd:MM:yyyy HH:mm"));
    @Override
    public JsonElement serialize(Calendar calendar, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(DATE_FORMAT.get().format(calendar.getTime()));
    }

    @Override
    public Calendar deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(DATE_FORMAT.get().parse(jsonElement.getAsJsonPrimitive().getAsString()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return calendar;
    }
}
