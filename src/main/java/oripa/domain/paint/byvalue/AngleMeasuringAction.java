package oripa.domain.paint.byvalue;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import oripa.domain.paint.GraphicMouseActionInterface;
import oripa.domain.paint.PaintContextInterface;
import oripa.domain.paint.core.GraphicMouseAction;

public class AngleMeasuringAction extends GraphicMouseAction {

	public AngleMeasuringAction() {
		setActionState(new SelectingVertexForAngle());
	}

	@Override
	public GraphicMouseActionInterface onLeftClick(final PaintContextInterface context,
			final boolean differentAction) {

		GraphicMouseActionInterface action;
		action = super.onLeftClick(context, differentAction);

		if (context.isMissionCompleted()) {
			action = new LineByValueAction();
		}

		return action;
	}

	@Override
	public void onDrag(final PaintContextInterface context, final AffineTransform affine,
			final boolean differentAction) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onRelease(final PaintContextInterface context, final AffineTransform affine,
			final boolean differentAction) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onDraw(final Graphics2D g2d, final PaintContextInterface context) {

		super.onDraw(g2d, context);

		drawPickCandidateVertex(g2d, context);

	}

	@Override
	public void onPress(final PaintContextInterface context, final AffineTransform affine,
			final boolean differentAction) {
		// TODO Auto-generated method stub

	}
}
