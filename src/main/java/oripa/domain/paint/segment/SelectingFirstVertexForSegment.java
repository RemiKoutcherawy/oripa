package oripa.domain.paint.segment;

import oripa.domain.paint.PaintContextInterface;
import oripa.domain.paint.core.PickingVertex;

public class SelectingFirstVertexForSegment extends PickingVertex {

	public SelectingFirstVertexForSegment() {
		super();
	}

	@Override
	public void undoAction(final PaintContextInterface context) {
		context.clear(false);
	}

	@Override
	public void onResult(final PaintContextInterface context, final boolean doSpecial) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void initialize() {
		setPreviousClass(this.getClass());
		setNextClass(SelectingSecondVertexForSegment.class);

//		System.out.println("SelectingFirstVertex.initialize() is called");
	}

}
