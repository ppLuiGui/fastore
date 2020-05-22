/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dtos;

import javax.swing.JPasswordField;

/**
 *
 * @author jose rivera
 */
public class UsuarioDTO {
    
    private static int id;
    private static String nombre;
    private static String ubicacion;
    private static String telefono;
    private static String correo;
    private static String password;
    private static String tipo_usuario;

    public static String getTipo_usuario() {
        return tipo_usuario;
    }

    public static void setTipo_usuario(String tipo_usuario) {
        UsuarioDTO.tipo_usuario = tipo_usuario;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        UsuarioDTO.id = id;
    }

    public static String getNombre() {
        return nombre;
    }

    public static void setNombre(String nombre) {
        UsuarioDTO.nombre = nombre;
    }

    public static String getUbicacion() {
        return ubicacion;
    }

    public static void setUbicacion(String ubicacion) {
        UsuarioDTO.ubicacion = ubicacion;
    }

    public static String getTelefono() {
        return telefono;
    }

    public static void setTelefono(String telefono) {
        UsuarioDTO.telefono = telefono;
    }

    public static String getCorreo() {
        return correo;
    }

    public static void setCorreo(String correo) {
        UsuarioDTO.correo = correo;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        UsuarioDTO.password = password;
    }

 
    
    
    
    public static String getHash(String txt, String hashType){
        try{
            java.security.MessageDigest md = java.security.MessageDigest.getInstance(hashType);
            byte[]array = md.digest(txt.getBytes());
            StringBuffer sb = new StringBuffer ();
            for(int i = 0; i < array.length; ++i){
                sb.append (Integer.toHexString(array [i] & 0xFF | 0x100).substring(1, 3));
                }
            return sb.toString();
            } catch (java.security.NoSuchAlgorithmException e){
    System.out.println(e.getMessage());
    }
            return null;
            
    
}
    public static String md5(String txt){
        return getHash(txt, "MD5");
        }
    public static String sha1(String txt) {
        return getHash(txt, "SHA1");
    }

    public static String sha1(JPasswordField cont) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
