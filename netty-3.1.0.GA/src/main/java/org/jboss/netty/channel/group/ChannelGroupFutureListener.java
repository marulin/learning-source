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
package org.jboss.netty.channel.group;

import java.util.EventListener;

/**
 * Listens to the result of a {@link ChannelGroupFuture}.  The result of the
 * asynchronous {@link ChannelGroup} I/O operations is notified once this
 * listener is added by calling {@link ChannelGroupFuture#addListener(ChannelGroupFutureListener)}
 * and all I/O operations are complete.
 *
 * @author The Netty Project (netty-dev@lists.jboss.org)
 * @author Trustin Lee (tlee@redhat.com)
 *
 * @version $Rev: 1242 $, $Date: 2009-04-23 18:22:59 +0900 (Thu, 23 Apr 2009) $
 */
public interface ChannelGroupFutureListener extends EventListener {

    /**
     * Invoked when all I/O operations associated with the
     * {@link ChannelGroupFuture} have been completed.
     *
     * @param future  The source {@link ChannelGroupFuture} which called this
     *                callback.
     */
    void operationComplete(ChannelGroupFuture future) throws Exception;
}
