/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.notifications;

/**
 *
 * @author docente
 */
public class NotificationService {
    private EmailService emailService;
    
    public NotificationService(EmailService emailService){
        this.emailService = emailService;
    }
    
    public String notifyUser(String message, String recipient){
        boolean result = emailService.sendEmail(message, recipient);
        if(result){
            return "Email  succesul";
        }else{
            return "Please retry sending email";
        }
    }
}
