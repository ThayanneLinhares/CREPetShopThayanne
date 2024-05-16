package Helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.EnumSet;
import java.util.Random;

public class Helper {

	private static final AtomicInteger screenshotCount = new AtomicInteger(1);

	public static void takeScreenshot(WebDriver driver, String fileName) {
		// Check if the WebDriver supports taking screenshots
		if (driver instanceof TakesScreenshot) {
			TakesScreenshot screenshotDriver = (TakesScreenshot) driver;

			// Capture the screenshot as a file
			File screenshot = screenshotDriver.getScreenshotAs(OutputType.FILE);

			// Specify the base directory where you want to save the screenshots
			String baseScreenshotDirectory = "screenshots/";

			// Add the current date and a unique identifier to the file name
			String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
			String uniqueIdentifier = String.format("%03d", screenshotCount.getAndIncrement());
			String updatedFileName = fileName + "_" + timestamp + "_" + uniqueIdentifier + ".png";

			// Get the current directory (year/month)
			String currentYearMonth = new SimpleDateFormat("yyyyMM").format(new Date());
			Path screenshotDirectory = Paths.get(baseScreenshotDirectory, currentYearMonth);

			// Create the directory if it doesn't exist
			if (!Files.exists(screenshotDirectory)) {
				try {
					Files.createDirectories(screenshotDirectory);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			Path screenshotPath = screenshotDirectory.resolve(updatedFileName);

			try {
				// Move the screenshot file to the specified directory
				Files.move(screenshot.toPath(), screenshotPath);
				// System.out.println("Screenshot saved at: " + screenshotPath.toString());
			} catch (IOException ioException) {
				ioException.printStackTrace();
			}
		} else {
			System.out.println("WebDriver does not support taking screenshots.");
		}
	}

	public static String generateRandomIDString(int length) {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		StringBuilder sb = new StringBuilder();
		Random random = new Random();

		for (int i = 0; i < length; i++) {
			int index = random.nextInt(characters.length());
			sb.append(characters.charAt(index));
		}
		return sb.toString();
	}

	public static String generateUniqueEmail() {
		String baseEmail = "random123@gmail.com";
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String timestamp = dateFormat.format(new Date());
		return baseEmail.replace("@", "+" + timestamp + "@");
	}

	public static String generateRandomExpiryDate() {
		Random rand = new Random();

		// Generate a random month (1-12)
		int month = rand.nextInt(12) + 1;

		// Generate a random year between the current year and the next 10 years
		int currentYear = LocalDate.now().getYear();
		int year = currentYear + rand.nextInt(10);

		// Format the date as MM/YYYY
		String monthString = String.format("%02d", month); // Ensure two digits for month
		String yearString = String.format("%04d", year); // Ensure four digits for year

		return monthString + "/" + yearString;
	}

	public static String generateRandomVisaNumber() {
		Random rand = new Random();

		// Generate random digits for the 16-digit number
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 16; i++) {
			int digit = rand.nextInt(10); // Generate a random digit (0-9)
			sb.append(digit);

			// Add space after every 3 digits except for the last group
			if ((i + 1) % 4 == 0 && i != 15) {
				sb.append(" ");
			}
		}

		return sb.toString();
	}

	public static void deleteScreenshotsFolder() {
		String baseScreenshotDirectory = "screenshots/";

		try {
			// Create the directory path
			Path screenshotsPath = Paths.get(baseScreenshotDirectory);

			// Delete the directory and its contents recursively
			Files.walkFileTree(screenshotsPath, EnumSet.noneOf(FileVisitOption.class), Integer.MAX_VALUE,
					new SimpleFileVisitor<Path>() {
						@Override
						public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
							Files.delete(file);
							return FileVisitResult.CONTINUE;
						}

						@Override
						public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
							// Handle failures while visiting files, if necessary
							return FileVisitResult.CONTINUE;
						}

						@Override
						public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
							if (exc == null) {
								Files.delete(dir);
								return FileVisitResult.CONTINUE;
							} else {
								// Handle failures while visiting directories, if necessary
								return FileVisitResult.CONTINUE;
							}
						}
					});

			System.out.println("Screenshots folder deleted successfully.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
