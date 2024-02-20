/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancopersistencia.Encriptacion;


/**
 *Clase para encriptar cadenas de texto
 * @author yohan
 */
public class encriptacion {

    /**
     *Constructor vacio
     */
    public encriptacion() {
    }

    /**
     *Metodo para encriptar una contraseña
     * @param contraseña Contraseña que se quiere encriptar
     * @return Contraseña ya encriptada
     */
    public String encrypt(String contraseña)  {
        String Newstr = "";
        try {
            for (int i = 0; i < contraseña.length(); i++) {
                char ch = Character.toLowerCase(contraseña.charAt(i));
                Newstr = switch (ch) {
                    case 'a' -> Newstr + "{";
                    case 'b' -> Newstr + "}";
                    case 'c' -> Newstr + "#";
                    case 'd' -> Newstr + "~";
                    case 'e' -> Newstr + "+";
                    case 'f' -> Newstr + "-";
                    case 'g' -> Newstr + "*";
                    case 'h' -> Newstr + "@";
                    case 'i' -> Newstr + "/";
                    case 'j' -> Newstr + "\\";
                    case 'k' -> Newstr + "?";
                    case 'l' -> Newstr + "$";
                    case 'm' -> Newstr + "!";
                    case 'n' -> Newstr + "^";
                    case 'o' -> Newstr + "(";
                    case 'p' -> Newstr + ")";
                    case 'q' -> Newstr + "<";
                    case 'r' -> Newstr + ">";
                    case 's' -> Newstr + "=";
                    case 't' -> Newstr + ";";
                    case 'u' -> Newstr + ",";
                    case 'v' -> Newstr + "_";
                    case 'w' -> Newstr + "[";
                    case 'x' -> Newstr + "]";
                    case 'y' -> Newstr + ":";
                    case 'z' -> Newstr + "\"";
                    case ' ' -> Newstr + " ";
                    case '.' -> Newstr + '3';
                    case ',' -> Newstr + "1";
                    case '(' -> Newstr + '4';
                    case '\"' -> Newstr + '5';
                    case ')' -> Newstr + "7";
                    case '?' -> Newstr + "2";
                    case '!' -> Newstr + "8";
                    case '-' -> Newstr + "6";
                    case '%' -> Newstr + "9";
                    case '1' -> Newstr + "r";
                    case '2' -> Newstr + "k";
                    case '3' -> Newstr + "b";
                    case '4' -> Newstr + "e";
                    case '5' -> Newstr + "q";
                    case '6' -> Newstr + "h";
                    case '7' -> Newstr + "u";
                    case '8' -> Newstr + "y";
                    case '9' -> Newstr + "w";
                    case '0' -> Newstr + "z";
                    default -> Newstr + "0";
                };
            }
        } catch (Exception ioe) {
        }
        return Newstr;
    }

    /**
   *Metodo para desencriptar una contraseña
     * @param contraseña Contraseña que se quiere desencriptar
     * @return Contraseña ya desencriptada
     */
    public String decrypt(String contraseña) { 
        String Newstr="";  
        try {  
        for (int i=0;i<contraseña.length();i++)  
        {  
            char ch=Character.toLowerCase(contraseña.charAt(i));  
            Newstr = switch (ch) {
                case '{' -> Newstr+"A";
                case '}' -> Newstr+"B";
                case '#' -> Newstr+"C";
                case '~' -> Newstr+"D";
                case '+' -> Newstr+"E";
                case '-' -> Newstr+"F";
                case '*' -> Newstr+"G";
                case '@' -> Newstr+"H";
                case '/' -> Newstr+"I";
                case '\\' -> Newstr+"J";
                case '?' -> Newstr+"K";
                case '$' -> Newstr+"L";
                case '!' -> Newstr+"M";
                case '^' -> Newstr+"N";
                case '(' -> Newstr+"O";
                case ')' -> Newstr+"P";
                case '<' -> Newstr+"Q";
                case '>' -> Newstr+"R";
                case '=' -> Newstr+"S";
                case ';' -> Newstr+"T";
                case ',' -> Newstr+"U";
                case '_' -> Newstr+"V";
                case '[' -> Newstr+"W";
                case ']' -> Newstr+"X";
                case ':' -> Newstr+"Y";
                case '\"' -> Newstr+"Z";
                case '1' -> Newstr+"r";
                case '2' -> Newstr+"k";
                case '3' -> Newstr+"b";
                case '4' -> Newstr+"e";
                case '5' -> Newstr+"q";
                case '6' -> Newstr+"h";
                case '7' -> Newstr+"u";
                case '8' -> Newstr+"y";
                case '9' -> Newstr+"w";
                case '0' -> Newstr+"z";
                default -> Newstr+"0";
            };  
        }  
        }  
        catch(Exception ioe)  
        {  
        }  
        return Newstr;
    }

}
