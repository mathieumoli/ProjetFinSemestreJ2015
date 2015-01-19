/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2014
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package fr.techcode.zuul.i18n;

import com.google.common.base.Strings;
import com.google.common.primitives.Ints;
import fr.techcode.zuul.util.MappedProperties;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * This is a basic i18n implementation.
 */
public final class I18n {

    // Format pattern
    private static final Pattern FORMAT = Pattern.compile("@([0-9]+)");

    // Messages reference
    private static MappedProperties messages = new MappedProperties(Message.en().toMap());

    // Default message
    private final static String def = "Unknown reference key";

    /**
     * Sets the lang of the i18n based on a message mapping.
     *
     * @param lang message mapping base.
     */
    public static void setLang(Message lang) {
        checkNotNull(lang, "The lang can't be null");
        messages.load(lang.toMap());
    }

    /**
     * Get a message in the defined lang
     *
     * @param key  Key to message
     * @param args Some arguments for a powerful format
     * @return Message translate or Key
     */
    public static String get(String key, String... args) {
        String val = messages.get(key);
        return (Strings.isNullOrEmpty(val)) ? def : format(val, args);
    }

    /**
     * Gets the map that represent the lang mapping.
     *
     * @return map that represent the lang mapping.
     */
    public static MappedProperties getMapping() {
        return messages;
    }

    /**
     * Format a message to a given String.
     *
     * @param raw       raw value.
     * @param arguments arguments replacements.
     * @return string result.
     */
    private static String format(String raw, String... arguments) {
        // Check if the format process is needed
        if (arguments.length == 0) return raw;

        // Needed
        Matcher match = FORMAT.matcher(raw);
        StringBuffer buffer = new StringBuffer(256);
        while (match.find()) {
            String replacement = match.group(1);
            Integer index = Ints.tryParse(replacement);
            if (index == null || index < 0 || index >= arguments.length) continue;
            replacement = arguments[index];
            match.appendReplacement(buffer, replacement);
        }
        match.appendTail(buffer);
        return buffer.toString();
    }

}
