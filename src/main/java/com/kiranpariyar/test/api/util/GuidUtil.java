package com.kiranpariyar.test.api.util;

import java.util.UUID;

public class GuidUtil {
    private GuidUtil() {
    }

    /**
     * Generate UUID.
     *
     * @return UUID
     */
    public static UUID generate() {
        return UUID.randomUUID();
    }
}
