/*
 * JBoss, Home of Professional Open Source
 *
 * Copyright 2009, Red Hat Middleware LLC, and individual contributors
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
package org.jboss.netty.handler.codec.http;

import org.jboss.netty.buffer.ChannelBuffer;

/**
 * The default {@link HttpChunk} implementation.
 *
 * @author The Netty Project (netty-dev@lists.jboss.org)
 * @author Trustin Lee (tlee@redhat.com)
 * @version $Rev: 1469 $, $Date: 2009-06-19 23:49:26 +0900 (Fri, 19 Jun 2009) $
 */
public class DefaultHttpChunk implements HttpChunk {

    private final ChannelBuffer content;
    private final boolean last;

    /**
     * Creates a new instance with the specified chunk content. If an empty
     * buffer is specified, this chunk becomes the 'end of content' marker.
     */
    public DefaultHttpChunk(ChannelBuffer content) {
        if (content == null) {
            throw new NullPointerException("content");
        }
        last = !content.readable();
        this.content = content;
    }

    public ChannelBuffer getContent() {
        return content;
    }

    public boolean isLast() {
        return last;
    }
}
