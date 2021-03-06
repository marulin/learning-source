/*
 * JBoss, Home of Professional Open Source
 *
 * Copyright 2008, Red Hat Middleware LLC, and individual contributors
 * by the @author tags. See the COPYRIGHT.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.netty.handler.codec.embedder;

/**
 * A helper that wraps an encoder or a decoder (codec) so that they can be used
 * without doing actual I/O in unit tests or higher level codecs.  Please refer
 * to {@link EncoderEmbedder} and {@link DecoderEmbedder} for more information.
 *
 * @author The Netty Project (netty-dev@lists.jboss.org)
 * @author Trustin Lee (tlee@redhat.com)
 * @version $Rev: 1436 $, $Date: 2009-06-18 20:16:06 +0900 (Thu, 18 Jun 2009) $
 */
public interface CodecEmbedder<T> {
    /**
     * Offers an input object to the pipeline of this embedder.
     *
     * @return {@code true} if and only if there is something to read in the
     *         product queue (see {@link #poll()} and {@link #peek()})
     */
    boolean offer(Object input);

    /**
     * Signals the pipeline that the encoding or decoding has been finished and
     * no more data will be offered.
     *
     * @return {@code true} if and only if there is something to read in the
     *         product queue (see {@link #poll()} and {@link #peek()})
     */
    boolean finish();

    /**
     * Consumes an encoded or decoded output from the product queue. The output
     * object is generated by the offered input objects.
     *
     * @return an encoded or decoded object.
     *         {@code null} if and only if there is no output object left in the
     *         product queue.
     */
    T poll();

    /**
     * Reads an encoded or decoded output from the head of the product queue.
     * The difference from {@link #poll()} is that it does not remove the
     * retrieved object from the product queue.
     *
     * @return an encoded or decoded object.
     *         {@code null} if and only if there is no output object left in the
     *         product queue.
     */
    T peek();
}
