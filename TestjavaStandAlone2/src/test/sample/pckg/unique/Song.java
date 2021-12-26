package test.sample.pckg.unique;

public class Song {
    private String name;
    private Song nextSong;

    public Song(String name) {
        this.name = name;
    }

    public void setNextSong(Song nextSong) {
        this.nextSong = nextSong;
    }

    public boolean isRepeatingPlaylist() {
        
        Song firstSong = this;
        Song curSong = this;
        while(this.nextSong != null){
            
            curSong = curSong.nextSong;
            
            if(curSong.equals(firstSong)){
                return true;
            }
            if(this.nextSong == null){
                return true;
            }
        }
        
        return true;
    }

    public static void main(String[] args) {
        Song first = new Song("Hello");
        Song second = new Song("Eye of the tiger");

        first.setNextSong(second);
        second.setNextSong(first);

        System.out.println(first.isRepeatingPlaylist());
    }
}