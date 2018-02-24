package com.bmstu.poses.capture.serialization._import;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;

import com.bmstu.poses.capture.model.Skeleton;

/**
 *
 * CSV implementation of {@link ISkeletonReader}.
 *
 * @author Bolshakov
 *
 */
public class CsvSkeletonReader extends StringSkeletonReader implements ISkeletonReader {

	@Override
	public Collection<Skeleton> importSkeletons(String pathToFile) {
		try {
			List<String> lines = Files.readAllLines(Paths.get(pathToFile).toAbsolutePath());
			return stringLinesToSkeletons(lines);
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
}
