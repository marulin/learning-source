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
package org.jboss.netty.channel.socket.nio;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelPipelineCoverage;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

/**
 *
 * @author The Netty Project (netty-dev@lists.jboss.org)
 * @author Daniel Bevenius (dbevenius@jboss.com)
 * @version $Rev: 1343 $, $Date: 2009-06-11 14:03:53 +0900 (Thu, 11 Jun 2009) $
 */
@ChannelPipelineCoverage("all")
public class SimpleHandler extends SimpleChannelHandler {

    @Override
    public void messageReceived(final ChannelHandlerContext ctx,
            final MessageEvent e) throws Exception {
        final ChannelBuffer cb = (ChannelBuffer) e.getMessage();
        final byte[] actual = new byte[cb.readableBytes()];
        cb.getBytes(0, actual);
        //System.out.println("TestHandler payload : " + new String(actual));
        ctx.sendDownstream(e);
    }
}
