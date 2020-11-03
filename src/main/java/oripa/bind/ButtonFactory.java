package oripa.bind;

import java.awt.Component;
import java.awt.event.KeyListener;

import javax.swing.AbstractButton;

import oripa.domain.paint.MouseActionHolder;
import oripa.domain.paint.ScreenUpdaterInterface;

/**
 * A factory which creates some clickable GUI object with a state to be after
 * the object is clicked.
 *
 * @author Koji
 *
 */
public interface ButtonFactory {

	public abstract AbstractButton create(Component parent,
			Class<? extends AbstractButton> buttonClass,
			final MouseActionHolder actionHolder,
			final ScreenUpdaterInterface screenUpater,
			String id,
			KeyListener keyListener);

}