package stepDefinitions;

import java.util.*;

public class AbsenceTestHelper {

    // ===== État global simulé du système =====
    private static boolean studentLoggedIn = false;
    private static boolean teacherLoggedIn = false;
    private static boolean adminLoggedIn = false;

    private static int remainingHalfDays = 8;
    private static String requestStatus = "";
    private static String visibleMessage = "";
    private static String notificationMessage = "";
    private static String errorMessage = "";
    private static String warningMessage = "";

    private static final Map<String, String> absenceRequests = new HashMap<>();
    private static final List<String> justifications = new ArrayList<>();

    // ===== Connexion utilisateur =====
    public static void loginAs(String role) {
        studentLoggedIn = role.equals("student");
        teacherLoggedIn = role.equals("teacher");
        adminLoggedIn = role.equals("admin");
        visibleMessage = "Logged in as " + role;
    }

    // ===== Soumission d'une demande d'absence =====
    public static void fillForm(String date, String reason) {
        absenceRequests.put(date, reason);
        visibleMessage = "Form filled for date: " + date + " with reason: " + reason;
    }

    public static void submitAbsenceRequest(String date) {
        if (absenceRequests.containsKey(date)) {
            requestStatus = "Submitted";
            remainingHalfDays--;
            visibleMessage = "Request submitted and visible in dashboard";
        } else {
            errorMessage = "Form not filled properly";
        }
    }

    // ===== Consultation du solde =====
    public static String getRemainingHalfDaysDisplay() {
        return "Remaining: " + remainingHalfDays + " half-days";
    }

    // ===== Téléversement de justificatif =====
    public static void uploadJustification(String fileName) {
        justifications.add(fileName);
        visibleMessage = "Justification attached: " + fileName;
    }

    // ===== Validation / Refus par admin =====
    public static void openRequestForReview() {
        visibleMessage = "Request opened for validation";
    }

    public static void validateRequest(String date) {
        if (absenceRequests.containsKey(date)) {
            requestStatus = "Validated";
        } else {
            errorMessage = "No request found for validation";
        }
    }

    // ===== Notification =====
    public static void triggerNotification(String message) {
        notificationMessage = message;
    }

    // ===== Marquage de présence =====
    public static void markStudentAbsent(String studentId, String date) {
        absenceRequests.put(date, "Marked absent");
        requestStatus = "Absent";
        visibleMessage = "Absence recorded for " + studentId;
    }

    // ===== Modification de demande =====
    public static void modifyAbsenceRequest(String oldDate, String newDate) {
        if (absenceRequests.containsKey(oldDate)) {
            String reason = absenceRequests.remove(oldDate);
            absenceRequests.put(newDate, reason);
            visibleMessage = "Request updated successfully with new date: " + newDate;
        } else {
            errorMessage = "Request not found to update";
        }
    }

    // ===== Export de données =====
    public static void exportAbsenceData() {
        visibleMessage = "Export complete: absences.xlsx";
    }

    // ===== Alerte d’absentéisme élevé =====
    public static void checkHighAbsenteeism(String studentId, int count) {
        if (count > 6) {
            warningMessage = "ALERT: High absenteeism detected";
            visibleMessage = warningMessage;
        }
    }

    // ===== Getters pour assertions (faciles à mocker/tester) =====
    public static String getRequestStatus() {
        return requestStatus;
    }

    public static String getVisibleMessage() {
        return visibleMessage;
    }

    public static String getNotificationMessage() {
        return notificationMessage;
    }

    public static String getErrorMessage() {
        return errorMessage;
    }

    public static String getWarningMessage() {
        return warningMessage;
    }

    public static int getRemainingHalfDays() {
        return remainingHalfDays;
    }

    public static void openClassSession() {
        if (teacherLoggedIn) {
            visibleMessage = "Class session opened";
        } else {
            errorMessage = "Only teachers can open class sessions";
        }
    }

    // ===== Reset (utile pour tests) =====
    public static void resetState() {
        studentLoggedIn = false;
        teacherLoggedIn = false;
        adminLoggedIn = false;
        remainingHalfDays = 8;
        requestStatus = "";
        visibleMessage = "";
        notificationMessage = "";
        errorMessage = "";
        warningMessage = "";
        absenceRequests.clear();
        justifications.clear();
    }


}
