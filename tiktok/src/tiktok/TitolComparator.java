package tiktok;

import java.util.Comparator;
import Model.VideoTiktok;

public class TitolComparator implements Comparator<VideoTiktok> {
    @Override
    public int compare(VideoTiktok v1, VideoTiktok v2) {
        // Ordenar alfabèticament per títol
        return v1.getTitol().compareToIgnoreCase(v2.getTitol());
    }
}