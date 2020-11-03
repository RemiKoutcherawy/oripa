/**
 * ORIPA - Origami Pattern Editor 
 * Copyright (C) 2013-     ORIPA OSS Project  https://github.com/oripa/oripa
 * Copyright (C) 2005-2009 Jun Mitani         http://mitani.cs.tsukuba.ac.jp/

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
package oripa.viewsetting.main;

import oripa.domain.paint.ScreenUpdaterInterface;
import oripa.util.gui.CallbackOnUpdate;

/**
 * @author Koji
 * 
 */
public class ScreenUpdaterAsCallback implements CallbackOnUpdate {

	private final ScreenUpdaterInterface updater;

	/**
	 * Constructor.
	 */
	public ScreenUpdaterAsCallback(final ScreenUpdaterInterface u) {
		updater = u;
	}

	/*
	 * (non Javadoc)
	 * 
	 * @see oripa.util.gui.CallbackOnUpdate#onUpdate()
	 */
	@Override
	public void onUpdate() {
		updater.updateScreen();
	}

}
