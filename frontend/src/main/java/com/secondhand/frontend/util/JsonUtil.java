package com.secondhand.frontend.util;

import com.google.gson.*;
import java.lang.reflect.Type;
import java.time.LocalDateTime;

public final class JsonUtil {

    private JsonUtil() {}

    private static final Gson GSON =
            new GsonBuilder()
                    .registerTypeAdapter(LocalDateTime.class,
                            new JsonDeserializer<LocalDateTime>() {
                                @Override
                                public LocalDateTime deserialize(
                                        JsonElement json,
                                        Type typeOfT,
                                        JsonDeserializationContext context
                                ) {
                                    return LocalDateTime.parse(json.getAsString());
                                }
                            })
                    .create();

    public static Gson getGson() {
        return GSON;
    }
}