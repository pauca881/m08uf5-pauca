package Model;

import java.util.Objects;

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
    
    @Override
    public int compareTo(VideoTiktok altre) {
        // Ordenació natural per nombre de likes (de menys a més)
        return Integer.compare(this.likes, altre.likes);
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VideoTiktok that = (VideoTiktok) o;
        return Double.compare(that.durada, durada) == 0 &&
                Objects.equals(usuari, that.usuari) &&
                Objects.equals(titol, that.titol);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(usuari, titol, durada);
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