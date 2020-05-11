package designpatterns.gof.behavioral.visitor.sad_dispatch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class TheMatrixReloaded {
	interface ISurface {
		void Add(LineSegment segment);
	}

	static class Paper implements ISurface {
		List<LineSegment> _segments = new ArrayList<LineSegment>();

		public void Add(LineSegment segment) {
			_segments.add(segment);
		}
	}

	static class EtchASketch implements ISurface {
		List<LineSegment> _segments = new ArrayList<LineSegment>();

		public void Add(LineSegment segment) {
			_segments.add(segment);
		}
	}

	static class Point {
		public Point(int x, int y) {
			this.X = x;
			this.Y = y;
		}

		public int X;
		public int Y;
	}

	static class LineSegment {
		public LineSegment(Point point1, Point point2) {
			Point1 = point1;
			Point2 = point2;
		}

		public Point Point1;
		public Point Point2;
	}

	static interface IShape {
		List<LineSegment> GetLineSegments();
	}

	static class Polygon implements IShape {
		public List<LineSegment> GetLineSegments() {
			List<LineSegment> segments = new ArrayList<LineSegment>();
			segments.add(new LineSegment(new Point(0, 0), new Point(0, 9)));
			segments.add(new LineSegment(new Point(0, 9), new Point(3, 6)));
			segments.add(new LineSegment(new Point(3, 6), new Point(6, 9)));
			segments.add(new LineSegment(new Point(6, 0), new Point(6, 9)));
			segments.add(new LineSegment(new Point(6, 0), new Point(3, 3)));
			segments.add(new LineSegment(new Point(3, 3), new Point(0, 0)));

			return segments;
		}
	}

	static class Quadrilateral implements IShape {
		public List<LineSegment> GetLineSegments() {
			List<LineSegment> segments = new ArrayList<LineSegment>();
			segments.add(new LineSegment(new Point(0, 0), new Point(0, 9)));
			segments.add(new LineSegment(new Point(0, 9), new Point(4, 5)));
			segments.add(new LineSegment(new Point(4, 0), new Point(0, 4)));
			segments.add(new LineSegment(new Point(4, 0), new Point(0, 0)));

			return segments;
		}
	}

	static class Parallelogram implements IShape {
		public List<LineSegment> GetLineSegments() {
			List<LineSegment> segments = new ArrayList<LineSegment>();
			segments.add(new LineSegment(new Point(0, 4), new Point(0, 9)));
			segments.add(new LineSegment(new Point(0, 9), new Point(4, 5)));
			segments.add(new LineSegment(new Point(4, 0), new Point(4, 5)));
			segments.add(new LineSegment(new Point(4, 0), new Point(0, 4)));

			return segments;
		}
	}

	static class Rectangle implements IShape {
		public List<LineSegment> GetLineSegments() {
			List<LineSegment> segments = new ArrayList<LineSegment>();
			segments.add(new LineSegment(new Point(0, 0), new Point(0, 9)));
			segments.add(new LineSegment(new Point(0, 9), new Point(9, 4)));
			segments.add(new LineSegment(new Point(4, 0), new Point(9, 4)));
			segments.add(new LineSegment(new Point(4, 0), new Point(0, 0)));

			return segments;
		}
	}

	static HashMap<String, IBrush> brushDictionary = new HashMap<String, IBrush>();

	static {
		brushDictionary.put("Paper", new Pencil());
		brushDictionary.put("EtchASketch", new EtchASketchKnobs());
	}

	public static void main(String[] args) {
		List<ISurface> surfaces = Arrays.asList(new Paper(), new EtchASketch());

		List<IShape> shapes = Arrays.asList(new Polygon(), new Quadrilateral(),
				new Parallelogram(), new Rectangle());

		for (ISurface surface : surfaces)
			for (IShape shape : shapes) {
				Console.WriteLine(String.format("Drawing a {0} on the {1} ...",
						shape.getClass(), surface.getClass().getSimpleName()));
				brushDictionary.get(surface.getClass().getSimpleName()).Draw(
						surface, shape.GetLineSegments());
				Console.WriteLine();
			}

		Console.ReadLine();
	}

	static interface IBrush {
		void Draw(ISurface surface, List<LineSegment> segments);
	}

	static class Pencil implements IBrush {
		public void Draw(ISurface surface, List<LineSegment> segments) {
			for (LineSegment segment : segments) {
				Console.WriteLine(String
						.format("Pencil used to sketch line segment {0},{1} to {2},{3}.",
								segment.Point1.X, segment.Point1.Y,
								segment.Point2.X, segment.Point2.Y));
			}
		}
	}

	static class EtchASketchKnobs implements IBrush {
		public void Draw(ISurface surface, List<LineSegment> segments) {
			for (LineSegment segment : segments) {
				Console.WriteLine(String
						.format("Knobs used to produce line segment {0},{1} to {2},{3}.",
								segment.Point1.X, segment.Point1.Y,
								segment.Point2.X, segment.Point2.Y));
			}
		}
	}
}
