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

package oripa.persistent.doc.exporter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

import oripa.domain.fold.OriFace;
import oripa.domain.fold.OriHalfedge;
import oripa.domain.fold.OriVertex;
import oripa.domain.fold.OrigamiModel;
import oripa.persistent.doc.Doc;
import oripa.persistent.doc.EstimationEntityHolder;
import oripa.persistent.entity.exporter.OrigamiModelExporterOBJ;

/**
 * 
 * 
 * @author MITANI Jun, OUCHI Koji
 * 
 */
// export folded model
public class ModelExporterOBJ implements DocExporter {

	public static void export_bk(final EstimationEntityHolder doc, final String filepath) throws Exception {
		OrigamiModel origamiModel = doc.getOrigamiModel();
		double paperSize = origamiModel.getPaperSize();

		List<OriFace> faces = origamiModel.getFaces();
		List<OriVertex> vertices = origamiModel.getVertices();

		FileWriter fw = new FileWriter(filepath);
		BufferedWriter bw = new BufferedWriter(fw);

		// Align the center of the model, combine scales
		bw.write("# Created by ORIPA\n");
		bw.write("\n");

		int id = 1;
		for (OriVertex vertex : vertices) {
			bw.write("v " + vertex.p.x + " " + vertex.p.y + " 0.0\n");
			vertex.tmpInt = id;
			id++;
		}

		for (OriVertex vertex : vertices) {
			bw.write("vt " + (vertex.preP.x + paperSize / 2) / paperSize + " "
					+ (vertex.preP.y + paperSize / 2) / paperSize + "\n");
		}

		for (OriFace face : faces) {
			bw.write("f");
			for (OriHalfedge he : face.halfedges) {
				bw.write(" " + he.vertex.tmpInt + "/" + he.vertex.tmpInt);
			}
			bw.write("\n");
		}

		bw.close();
	}

	@Override
	public boolean export(final Doc doc, final String filePath) throws Exception {
		OrigamiModelExporterOBJ exporter = new OrigamiModelExporterOBJ();

		OrigamiModel origamiModel = doc.getOrigamiModel();

		return exporter.export(origamiModel, filePath);

	}

}
