/*
 * ShinyAppsDeploymentOutputEvent.java
 *
 * Copyright (C) 2009-14 by RStudio, Inc.
 *
 * Unless you have received this program directly from RStudio pursuant
 * to the terms of a commercial license agreement with RStudio, then
 * this program is licensed to you under the terms of version 3 of the
 * GNU Affero General Public License. This program is distributed WITHOUT
 * ANY EXPRESS OR IMPLIED WARRANTY, INCLUDING THOSE OF NON-INFRINGEMENT,
 * MERCHANTABILITY OR FITNESS FOR A PARTICULAR PURPOSE. Please refer to the
 * AGPL (http://www.gnu.org/licenses/agpl-3.0.txt) for more details.
 *
 */
package org.rstudio.studio.client.shiny.events;

import org.rstudio.studio.client.common.compile.CompileOutput;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class ShinyAppsDeploymentOutputEvent extends GwtEvent<ShinyAppsDeploymentOutputEvent.Handler>
{ 
   public interface Handler extends EventHandler
   {
      void onShinyAppsDeploymentOutput(ShinyAppsDeploymentOutputEvent event);
   }

   public static final GwtEvent.Type<ShinyAppsDeploymentOutputEvent.Handler> TYPE =
      new GwtEvent.Type<ShinyAppsDeploymentOutputEvent.Handler>();
   
   public ShinyAppsDeploymentOutputEvent(CompileOutput output)
   {
      output_ = output;
   }
   
   public CompileOutput getOutput()
   {
      return output_;
   }
   
   @Override
   protected void dispatch(ShinyAppsDeploymentOutputEvent.Handler handler)
   {
      handler.onShinyAppsDeploymentOutput(this);
   }

   @Override
   public GwtEvent.Type<ShinyAppsDeploymentOutputEvent.Handler> getAssociatedType()
   {
      return TYPE;
   }
   
   private CompileOutput output_;
}
