package tiktok;

import java.util.Comparator;

import Model.VideoTiktok;

public class DuradaComparator implements Comparator<VideoTiktok> {
    @Override
    public int compare(VideoTiktok v1, VideoTiktok v2) {
        // Ordenar del més curt al més llarg
        return Double.compare(v1.getDurada(), v2.getDurada());
    }
}