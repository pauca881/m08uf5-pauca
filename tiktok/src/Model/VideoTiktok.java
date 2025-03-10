package Model;

public class VideoTiktok implements Comparable<VideoTiktok> {
    private int id;
    private String usuari;
    private String titol;
    private int likes;
    private double durada;
    
    public VideoTiktok(int id, String usuari, String titol, int likes, double durada) {
        this.id = id;
        this.usuari = usuari;
        this.titol = titol;
        this.likes = likes;
        this.durada = durada;
    }
    
    
    //no he ficat setters en:
    
    // id perquè no s'ha de modificar
    //  usuari perquè un vídeo pertany a un usuari específic i no canvia
    //  durada perquè un cop pujat el vídeo, la durada és fixa osigui no canvia
    
    public String getUsuari() {
        return usuari;
    }
    
    public String getTitol() {
        return titol;
    }
    
    public void setTitol(String titol) {
        this.titol = titol;
    }
    
    public int getLikes() {
        return likes;
    }
    
    public void setLikes(int likes) {
        this.likes = likes;
    }
    
    public double getDurada() {
        return durada;
    }
    
    
    //aquest mètode serveix per comparar numero de likes d'un video i l'altre
    @Override
    public int compareTo(VideoTiktok altre) {
        return Integer.compare(this.likes, altre.likes);
    }
    
  
  
    
    @Override
    public String toString() {
        return "VideoTikTok{" +
                "id=" + id +
                ", usuari='" + usuari + '\'' +
                ", titol='" + titol + '\'' +
                ", likes=" + likes +
                ", durada=" + durada +
                '}';
    }
}