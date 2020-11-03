package oripa.domain.cptool;

import java.util.ArrayList;
import java.util.Collection;

import javax.vecmath.Vector2d;

import oripa.geom.GeomUtil;
import oripa.value.OriLine;

public class LineDivider {

	/**
	 *
	 * @param line
	 * @param v
	 * @param creasePattern
	 * @param paperSize
	 * @return collection containing 2 lines that are the result of division.
	 *         null if not need to divides
	 */
	public Collection<OriLine> divideLineInCollection(
			final OriLine line, final Vector2d v,
			final Collection<OriLine> creasePattern, final double paperSize) {
		ArrayList<OriLine> divided = new ArrayList<>(2);

		// Normally you don't want to add a vertex too close to the end of the
		// line
		if (GeomUtil.Distance(line.p0, v) < paperSize * 0.001
				|| GeomUtil.Distance(line.p1, v) < paperSize * 0.001) {
			return null;
		}

		divided.add(new OriLine(line.p0, v, line.typeVal));
		divided.add(new OriLine(v, line.p1, line.typeVal));

		return divided;
	}

}
