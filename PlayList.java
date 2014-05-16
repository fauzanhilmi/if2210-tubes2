/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package giga.music.player;

import java.util.ArrayList;

/**
 *
 * @author Fauzan
 */
public class PlayList {

    private ArrayList<Song> playlist = new ArrayList<>();
    String PlaylistTitle ;

    public void addSong(Song song) {
        playlist.add(song);
    }

    public void delSong(Song song) {
        playlist.remove(song);
    }

      
    public Song getSongByTitle(String title) {
        boolean found = false;
        int i = 0;
        while ((!found) && (i<playlist.size()))
        {
            if (title.equals(playlist.get(i).getTitle()))
                found = true;
            else
                i++;
        }
        if (found)
            return playlist.get(i);
        else
            return null;
    }

    public int getIndexByTitle(String title) {
        int index = -1;
        boolean found = false;
        int i = 0;
        while ((!found) && (i<playlist.size()))
        {
            if (title.equals(playlist.get(i).getTitle()))
            {
                found = true;
                index = i;
            }
            else
                i++;
        }
        return index;
            
    }

    public ArrayList<Song> getSongsByArtist(String artist) {
        int i;
        ArrayList<Song> tmp = new ArrayList<>();
        for (i = 0; i < playlist.size(); i++) {
            if (artist.equals(playlist.get(i).getArtist())) {
                tmp.add(playlist.get(i));
            }
        }
        return tmp;
    }

    /*
     public int getIndex(String artist) {
     int index = -1;
     for (int i = 0; i < playlist.size(); i++) {
     if (artist.equals(playlist.get(i).getTitle())) {
     index=i;
     }
     }
     return index;
     }
     */
    public ArrayList<Song> getSongsByGenre(String genre) {
        ArrayList<Song> tmp = new ArrayList<>();
        for (Song playlist1 : playlist) {
            if (genre.equals(playlist1.getGenre())) {
                tmp.add(playlist1);
            }
        }
        return tmp;
    }

    /*
     public int getIndexByGenre(String genre) {
     int index = -1;
     for (int i = 0; i < playlist.size(); i++) {
     if (genre.equals(playlist.get(i).getGenre())) {
     index=i;
     }
     }
     return index;
     }
     */
    public ArrayList<Song> getSongsByAlbum(String album) {
        ArrayList<Song> tmp = new ArrayList<>();
        for (int i = 0; i < playlist.size(); i++) {
            if (album.equals(playlist.get(i).getAlbum())) {
                tmp.add(playlist.get(i));
            }
        }
        return tmp;
    }

    /*
     public int getIndexByAlbum(String album) {
     int index = -1;
     for (int i = 0; i < playlist.size(); i++) {
     if (genre.equals(playlist.get(i).getGenre())) {
     index=i;
     }
     }
     return index;
     }
     */
    /*
    public ArrayList<Song> getSongByRating(int rating) {
        ArrayList<Song> tmp = new ArrayList<>();
        for (int i = 0; i < playlist.size(); i++) {
            if (playlist.get(i).getRating() == rating) {
                tmp.add(playlist.get(i));
            }
        }
        return tmp;
    }*/

    /*
     public int getIndexByRating(String rating) {
     int index = -1;
     for (int i = 0; i < playlist.size(); i++) {
     if (genre.equals(playlist.get(i).getGenre())) {
     index=i;
     }
     } 
     return index;
     }
     */
    public void sortByTitle() {
        String[] holder = new String[playlist.size()];
        for (int i = 0; i < playlist.size(); i++) {
            holder[i] = playlist.get(i).getTitle();
        }
        //Sorting Title
        for (int i = 0; i < playlist.size(); i++) {
            int min = i;
            for (int j = i + 1; j < playlist.size(); j++) {
                //ignore case?
                if (holder[j].compareTo(holder[min]) < 0) {
                    min = j;
                }
            }
            String tmp = holder[min];
            holder[min] = holder[i];
            holder[i] = tmp;

            ArrayList<Song> smt = new ArrayList<>();
            for (String holder1 : holder) {
                smt.add(playlist.get(getIndexByTitle(holder1)));
            }

            playlist.clear();
            playlist.addAll(smt);
        }
    }

    public void sortByAlbum() {
        ArrayList<String> holders = new ArrayList<>();
        for (int i = 0; i < playlist.size(); i++) {
            if (!holders.contains(playlist.get(i).getAlbum())) {
                holders.add(playlist.get(i).getAlbum());
            }
        }
        String[] holder = (String[]) holders.toArray();
        for (int i = 0; i < playlist.size(); i++) {
            int min = i;
            for (int j = i + 1; j < playlist.size(); j++) {
                //ignore case?
                if (holder[j].compareTo(holder[min]) < 0) {
                    min = j;
                }
            }
            String tmp = holder[min];
            holder[min] = holder[i];
            holder[i] = tmp;

            ArrayList<Song> smt = new ArrayList<>();
            for (String holder1 : holder) {
                smt.addAll(getSongByAlbum(holder1));
            }

            playlist.clear();
            playlist.addAll(smt);
        }
    }

    public void sortByArtist() {
        ArrayList<String> holders = new ArrayList<>();
        for (int i = 0; i < playlist.size(); i++) {
            if (!holders.contains(playlist.get(i).getArtist())) {
                holders.add(playlist.get(i).getArtist());
            }
        }
        String[] holder = (String[]) holders.toArray();
        //Sorting Title
        for (int i = 0; i < playlist.size(); i++) {
            int min = i;
            for (int j = i + 1; j < playlist.size(); j++) {
                //ignore case?

                if (holder[j].compareTo(holder[min]) < 0) {
                    min = j;
                }
            }
            String tmp = holder[min];
            holder[min] = holder[i];
            holder[i] = tmp;

            ArrayList<Song> smt = new ArrayList<>();
            for (String holder1 : holder) {
                smt.addAll(getSongByArtist(holder1));
            }

            playlist.clear();
            playlist.addAll(smt);
        }
    }

    public void sortByGenre() {
        ArrayList<String> holders = new ArrayList<>();

        for (int i = 0; i < playlist.size(); i++) {
            if (!holders.contains(playlist.get(i).getGenre())) {
                holders.add(playlist.get(i).getGenre());
            }
        }
        //Sorting Title

        String[] holder = (String[]) holders.toArray();
        for (int i = 0; i < playlist.size(); i++) {
            int min = i;
            for (int j = i + 1; j < playlist.size(); j++) {
                //ignore case?
                if (holder[j].compareTo(holder[min]) < 0) {
                    min = j;
                }
            }
            String tmp = holder[min];
            holder[min] = holder[i];
            holder[i] = tmp;

            ArrayList<Song> smt = new ArrayList<>();
            for (String holder1 : holder) {
                smt.addAll(getSongByGenre(holder1));
            }

            playlist.clear();
            playlist.addAll(smt);
        }
    }

    /*
    public void sortByRating() {
        ArrayList<Integer> holders = new ArrayList<>();
        for (int i = 0; i < playlist.size(); i++) {
            if (!holders.contains(playlist.get(i).getRating())) {
                holders.add(playlist.get(i).getRating());
            }
        }
        Integer[] holder = (Integer[]) holders.toArray();
        for (int i = 0; i < playlist.size(); i++) {
            int min = i;
            for (int j = i + 1; j < playlist.size(); j++) {
                if (holder[j] < holder[min]) {
                    min = j;
                }
            }
            int tmp = holder[min];
            holder[min] = holder[i];
            holder[i] = tmp;

            ArrayList<Song> smt = new ArrayList<>();
            for (int holder1 : holder) {
                smt.addAll(getSongByRating(holder1));
            }

            playlist.clear();
            playlist.addAll(smt);
        }
    }
    */
    public void GroupByAlbum() {
        ArrayList<String> allAlbums = new ArrayList<>();
        ArrayList<Song> smt = new ArrayList<>();

        for (int i = 0; i < playlist.size(); i++) {
            if (!allAlbums.contains(playlist.get(i).getAlbum())) {
                allAlbums.add(playlist.get(i).getAlbum());
            }
        }
        allAlbums.stream().forEach((tmp) -> {
            smt.addAll(getSongByAlbum(tmp));
        });
        playlist.clear();
        playlist.addAll(smt);
    }

    public void GroupByGenre() {
        ArrayList<String> allGenre = new ArrayList<>();
        ArrayList<Song> smt = new ArrayList<>();

        for (int i = 0; i < playlist.size(); i++) {
            if (!allGenre.contains(playlist.get(i).getGenre())) {
                allGenre.add(playlist.get(i).getGenre());
            }
        }
        allGenre.stream().forEach((tmp) -> {
            smt.addAll(getSongByAlbum(tmp));
        });
        playlist.clear();
        playlist.addAll(smt);
    }

    public void GroupByArtist() {
        ArrayList<String> allArtist = new ArrayList<>();
        ArrayList<Song> smt = new ArrayList<>();

        for (int i = 0; i < playlist.size(); i++) {
            if (!allArtist.contains(playlist.get(i).getArtist())) {
                allArtist.add(playlist.get(i).getArtist());
            }
        }
        allArtist.stream().forEach((tmp) -> {
            smt.addAll(getSongByAlbum(tmp));
        });
        playlist.clear();
        playlist.addAll(smt);
    }
    
    /*
    public void GroupByRating() {
        ArrayList<Integer> allRating = new ArrayList<>();
        ArrayList<Song> smt = new ArrayList<>();

        for (int i = 0; i < playlist.size(); i++) {
            if (!allRating.contains(playlist.get(i).getRating())) {
                allRating.add(playlist.get(i).getRating());
            }
        }
        allRating.stream().forEach((Integer tmp) -> {
            smt.addAll(getSongByRating(tmp));
        });
        playlist.clear();
        playlist.addAll(smt);
    }
    */
}

