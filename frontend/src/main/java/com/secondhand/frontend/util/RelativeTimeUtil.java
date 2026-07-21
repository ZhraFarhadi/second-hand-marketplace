package com.secondhand.frontend.util;

import java.time.Duration;
import java.time.LocalDateTime;

public final class RelativeTimeUtil {

    private RelativeTimeUtil() {
    }

    public static String format(LocalDateTime time) {

        if (time == null) {
            return "";
        }

        Duration duration =
                Duration.between(time, LocalDateTime.now());

        long seconds = duration.getSeconds();

        if (seconds < 60) {
            return "Just now";
        }

        long minutes = seconds / 60;

        if (minutes < 60) {

            return minutes == 1
                    ? "1 minute ago"
                    : minutes + " minutes ago";

        }

        long hours = minutes / 60;

        if (hours < 24) {

            return hours == 1
                    ? "1 hour ago"
                    : hours + " hours ago";

        }

        long days = hours / 24;

        if (days == 1) {
            return "Yesterday";
        }

        if (days < 7) {
            return days + " days ago";
        }

        long weeks = days / 7;

        if (weeks < 5) {

            return weeks == 1
                    ? "1 week ago"
                    : weeks + " weeks ago";

        }

        long months = days / 30;

        if (months < 12) {

            return months == 1
                    ? "1 month ago"
                    : months + " months ago";

        }

        long years = days / 365;

        return years == 1
                ? "1 year ago"
                : years + " years ago";

    }

}