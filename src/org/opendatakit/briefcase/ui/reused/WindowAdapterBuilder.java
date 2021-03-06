/*
 * Copyright (C) 2018 Nafundi
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.opendatakit.briefcase.ui.reused;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Optional;
import java.util.function.Consumer;

public class WindowAdapterBuilder {
  private Optional<Consumer<WindowEvent>> onWindowClosing = Optional.empty();

  public WindowAdapterBuilder onClosing(Consumer<WindowEvent> callback) {
    this.onWindowClosing = Optional.ofNullable(callback);
    return this;
  }

  public WindowAdapter build() {
    return new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        onWindowClosing.ifPresent(c -> c.accept(e));
      }
    };
  }
}
