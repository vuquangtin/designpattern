package designpatterns.lambdas.behavioral.strategies;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipOutputStream;

/**
 * <h1>Strategy</h1> Định nghĩa tập hợp các thuật toán, đóng gói từng thuật toán
 * lại, và làm chúng hoán đổi lẫn nhau. Strategy cho phép thuật toán biến đổi
 * độc lập khi người dùng sử dụng chúng.
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com

 *      /vuquangtin/designpattern</a>
 *
 */
interface CompressionStrategy {
	public OutputStream compress(OutputStream data) throws IOException;
}

class Compressor {
	private final CompressionStrategy strategy;

	public Compressor(CompressionStrategy strategy) {
		this.strategy = strategy;
	}

	public void compress(Path inFile, File outFile) throws IOException {
		try (OutputStream outputStream = new FileOutputStream(outFile)) {
			Files.copy(inFile, strategy.compress(outputStream));
		}
	}
}

public class Main {
	public static void main(String[] args) throws Exception {
		Compressor gzipCompressor = new Compressor(GZIPOutputStream::new);
		gzipCompressor.compress(new File("outFile").toPath(), new File(
				"outFile"));
		Compressor zipCompressor = new Compressor(ZipOutputStream::new);
		zipCompressor.compress(new File("outFile").toPath(),
				new File("outFile"));
	}
}