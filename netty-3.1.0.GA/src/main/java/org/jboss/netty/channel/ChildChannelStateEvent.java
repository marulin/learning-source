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
package org.jboss.netty.channel;

/**
 * A {@link ChannelEvent} which represents the notification of the state of
 * a child {@link Channel}.  This event is for going upstream only.  Please
 * refer to the {@link ChannelEvent} documentation to find out what an upstream
 * event and a downstream event are and what fundamental differences they have.
 *
 * @author The Netty Project (netty-dev@lists.jboss.org)
 * @author Trustin Lee (tlee@redhat.com)
 *
 * @version $Rev: 1450 $, $Date: 2009-06-19 17:59:24 +0900 (Fri, 19 Jun 2009) $
 */
public interface ChildChannelStateEvent extends ChannelEvent {

    /**
     * Returns the <strong>parent</strong> {@link Channel} which is associated
     * with this event.  Please note that you should use {@link #getChildChannel()}
     * to get the {@link Channel} created or accepted by the parent {@link Channel}.
     */
    Channel getChannel();

    /**
     * Returns the child {@link Channel} whose state has been changed.
     */
    Channel getChildChannel();
}
