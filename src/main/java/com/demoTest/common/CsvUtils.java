package com.demoTest.common;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.apache.log4j.Logger;

public class CsvUtils {
	static Logger logger = Logger.getLogger(CsvUtils.class.getName());

	private HashMap<Point, String> _map = new HashMap<Point, String>();
	private int _cols;
	private int _rows;

	public void open(File file) throws FileNotFoundException, IOException {
		open(file, ',');
	}

	public void open(File file, char delimiter) throws FileNotFoundException, IOException {
		Scanner scanner = new Scanner(file);
		scanner.useDelimiter(Character.toString(delimiter));
		clear();
		while (scanner.hasNextLine()) {
			String[] values = scanner.nextLine().split(Character.toString(delimiter));
			int col = 0;
			for (String value : values) {
				_map.put(new Point(col, _rows), value);
				_cols = Math.max(_cols, ++col);
			}
			_rows++;
		}
		scanner.close();
	}

	public void save(File file) throws IOException {
		save(file, ',');
	}

	public void save(File file, char delimiter) throws IOException {
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		for (int row = 0; row < _rows; row++) {
			for (int col = 0; col < _cols; col++) {
				Point key = new Point(col, row);
				if (_map.containsKey(key)) {
					bw.write(_map.get(key));
				}
				if ((col + 1) < _cols) {
					bw.write(delimiter);
				}
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}

	public String get(int col, int row) {
		String val = "";
		Point key = new Point(col, row);
		if (_map.containsKey(key)) {
			val = _map.get(key);
		}
		return val;
	}

	public void put(int col, int row, String value) {
		_map.put(new Point(col, row), value);
		_cols = Math.max(_cols, col + 1);
		_rows = Math.max(_rows, row + 1);
	}

	public void clear() {
		_map.clear();
		_cols = 0;
		_rows = 0;
	}

	public int rows() {
		return _rows;
	}

	public int cols() {
		return _cols;
	}

	public static String replaceColumnValue(String line, String newValue, int columnIndex) throws Exception {
		String[] cols = line.split(",");
		if (!line.toUpperCase().contains("LOAN_NUMBER")) {
			cols[columnIndex] = newValue;
		}
		String newLine = cols[0];

		for (int j = 1; j < cols.length; j++) {
			newLine += "," + cols[j];
		}
		return newLine;
	}

	public static List<String> replaceMultipleColumnsrelativeDateWithAbsoluteDate(List<String> lines,
			String dateColumns) throws Exception {
		List<String> newLines = new ArrayList<String>();

		for (String line : lines) {
			line = replaceMultipleColumnsrelativeDateWithAbsoluteDate(line, dateColumns);
			newLines.add(line);
		}
		return newLines;
	}

	public static String replaceMultipleColumnsrelativeDateWithAbsoluteDate(String line, String dateColumns)
			throws Exception {
		int lineNumber = 0;
		for (String dateColumn : dateColumns.split(",")) {
			lineNumber++;

			Integer dateColumnNumber = Integer.parseInt(dateColumn) - 1;

			String[] cols = line.split(",");
			int len = cols.length;
			if (dateColumnNumber >= len) {
				throw new Exception("Error: invalid dateColumn " + dateColumn + ", there are only " + len
						+ " columns in line " + line);
			}
			String date = line.split(",")[dateColumnNumber];
			date = DateUtils.convertDate(date);
			line = CsvUtils.replaceColumnValue(line, date, dateColumnNumber);
			logger.info("line[" + lineNumber + "] = " + line);
		}
		return line;
	}

	public static List<String> filterDataRows(List<String> dataLines, Set<Integer> dataSet) {
		List<String> newLines = new ArrayList<String>();

		int rowNumber = 0;
		for (String line : dataLines) {
			rowNumber++;
			if (dataSet.contains(rowNumber)) {
				newLines.add(line);
			}
		}
		return newLines;
	}

	public int length(String fileName) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
		String input;
		int count = -1;
		while ((input = bufferedReader.readLine()) != null) {
			count++;
		}
		return count;
	}
}
