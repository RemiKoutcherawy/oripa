/**
 * ORIPA - Origami Pattern Editor
 * Copyright (C) 2005-2009 Jun Mitani http://mitani.cs.tsukuba.ac.jp/

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package oripa.view.estimation;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

import oripa.domain.fold.FoldedModelInfo;
import oripa.domain.fold.OrigamiModel;

public class EstimationResultFrame extends JFrame implements ActionListener {

	FoldedModelScreen screen;
	EstimationResultUI ui;
	public JLabel hintLabel;

	public EstimationResultFrame() {
		setTitle("Folded Origami");
		screen = new FoldedModelScreen();
		ui = new EstimationResultUI();
		ui.setScreen(screen);
		hintLabel = new JLabel("L: Rotate / Wheel: Zoom");
		setBounds(0, 0, 800, 600);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(ui, BorderLayout.WEST);
		getContentPane().add(screen, BorderLayout.CENTER);
		getContentPane().add(hintLabel, BorderLayout.SOUTH);

	}

	public void setModel(
			final OrigamiModel origamiModel, final FoldedModelInfo foldedModelInfo) {

		screen.setModel(origamiModel, foldedModelInfo);
		ui.setModel(origamiModel, foldedModelInfo);
		ui.updateLabel();
		// setVisible(true);
	}

	@Override
	public void actionPerformed(final ActionEvent arg0) {
		// TODO Auto-generated method stub
	}
}
