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

package org.opendatakit.briefcase.ui.reused.source;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Optional;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.opendatakit.briefcase.reused.BriefcaseException;

@SuppressWarnings("checkstyle:MethodName")
public class SelectSourceForm extends JComponent {
  private JComboBox<Source> sourceComboBox;
  private JButton configureButton;
  public JPanel container;
  private JLabel actionLabel;

  SelectSourceForm(String action) {
    $$$setupUI$$$();
    actionLabel.setText(action);

    configureButton.addActionListener(__ -> Optional.ofNullable((Source) sourceComboBox.getSelectedItem())
        .orElseThrow(BriefcaseException::new)
        .onSelect(container));
  }

  public JPanel getContainer() {
    return container;
  }

  void addSource(Source source) {
    sourceComboBox.addItem(source);
  }

  @Override
  public void setEnabled(boolean enabled) {
    super.setEnabled(enabled);
    sourceComboBox.setEnabled(enabled);
    configureButton.setEnabled(enabled);
  }

  private void createUIComponents() {
    // TODO: place custom component creation code here
  }

  /**
   * Method generated by IntelliJ IDEA GUI Designer
   * >>> IMPORTANT!! <<<
   * DO NOT edit this method OR call it in your code!
   *
   * @noinspection ALL
   */
  private void $$$setupUI$$$() {
    container = new JPanel();
    container.setLayout(new GridBagLayout());
    actionLabel = new JLabel();
    actionLabel.setText("Pull from");
    GridBagConstraints gbc;
    gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 0;
    container.add(actionLabel, gbc);
    sourceComboBox = new JComboBox();
    final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
    sourceComboBox.setModel(defaultComboBoxModel1);
    gbc = new GridBagConstraints();
    gbc.gridx = 2;
    gbc.gridy = 0;
    gbc.weightx = 1.0;
    gbc.anchor = GridBagConstraints.WEST;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    container.add(sourceComboBox, gbc);
    configureButton = new JButton();
    configureButton.setText("Configure");
    gbc = new GridBagConstraints();
    gbc.gridx = 4;
    gbc.gridy = 0;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    container.add(configureButton, gbc);
    final JPanel spacer1 = new JPanel();
    gbc = new GridBagConstraints();
    gbc.gridx = 1;
    gbc.gridy = 0;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    container.add(spacer1, gbc);
    final JPanel spacer2 = new JPanel();
    gbc = new GridBagConstraints();
    gbc.gridx = 3;
    gbc.gridy = 0;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    container.add(spacer2, gbc);
  }

  /**
   * @noinspection ALL
   */
  public JComponent $$$getRootComponent$$$() {
    return container;
  }
}
