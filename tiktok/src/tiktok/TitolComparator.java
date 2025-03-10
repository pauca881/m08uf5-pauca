package tiktok;

import java.util.Comparator;
import Model.VideoTiktok;

public class TitolComparator implements Comparator<VideoTiktok> {
    @Override
    public int compare(VideoTiktok v1, VideoTiktok v2) {
        return v1.getTitol().compareToIgnoreCase(v2.getTitol());
    }
    
    //utilitzo el mètode nadiu de java compareToIgnoreCase per comparar dos strings
    //compareToIgnore es nadiu de comparator
}