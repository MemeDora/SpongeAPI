/*
 * This file is part of SpongeAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered <https://www.spongepowered.org>
 * Copyright (c) contributors
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
package org.spongepowered.api.command.parameter.managed;

import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.parameter.Parameter;
import org.spongepowered.api.text.Text;

public interface ValueParameter extends ValueCompleter, ValueParser, ValueUsage {

    /**
     * Gets the usage string for the argument.
     *
     * <p>Default implemented to simply return the key.</p>
     *
     * @param key The {@link Text} that defines the parameter key
     * @param source The source requesting the usage
     * @return The usage
     */
    default Text getUsage(Text key, CommandSource source) {
        return key;
    }

    /**
     * Gets this {@link ValueParameter} as a {@link Parameter}.
     *
     * @param key The key for the parameter.
     * @param modifiers The {@link ValueParameterModifier}s to link with this parameter
     * @return The {@link Parameter}
     */
    default Parameter asParameter(String key, ValueParameterModifier... modifiers) {
        return Parameter.builder().setKey(key).setParser(this).modifiers(modifiers).build();
    }

    /**
     * Gets this {@link ValueParameter} as a {@link Parameter}.
     *
     * @param key The key for the parameter.
     * @param modifiers The {@link ValueParameterModifier}s to link with this parameter
     * @return The {@link Parameter}
     */
    default Parameter asParameter(Text key, ValueParameterModifier... modifiers) {
        return Parameter.builder().setKey(key).setParser(this).modifiers(modifiers).build();
    }

}
