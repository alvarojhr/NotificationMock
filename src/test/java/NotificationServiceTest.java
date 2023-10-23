
import com.mycompany.notifications.EmailService;
import com.mycompany.notifications.NotificationService;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author docente
 */
public class NotificationServiceTest {
    
    @InjectMocks
    NotificationService notificationService;
    
    @Test
    void testNotifyUserWhenSendingEmailIsSuccesful(){
        String message = "Hello World!";
        String recipient = "user@example.com";
        
        EmailService emailService=mock(EmailService.class);
        when(emailService.sendEmail(message, recipient)).thenReturn(true);
        
        notificationService = new NotificationService(emailService);
       
        String result = notificationService.notifyUser(message, recipient);
        
        assertEquals("Email send succesul",result);
    }
    
    @Test
    void testNotifyUserWhenSendingEmailIsFailing(){
        String message = "Hello World!";
        String recipient = "user@example.com";
        
        EmailService emailService=mock(EmailService.class);
        when(emailService.sendEmail(message, recipient)).thenReturn(false);
        
        notificationService = new NotificationService(emailService);
       
        String result = notificationService.notifyUser(message, recipient);
        
        assertEquals("Please retry sending email",result);
    }
}
