package com.wyymusic.main.model;

import java.util.List;

/**
 * @author tbx
 * @date 2021/1/5
 * target:
 * time: 2021/1/5
 * God Bless my code!
 **/
public class SearchResponse {

    private Result result;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("SearchResponse{");
        sb.append("result=").append(result);
        sb.append('}');
        return sb.toString();
    }

    public class Result {
        private List<Songs> songs;

        public List<Songs> getSongs() {
            return songs;
        }

        public void setSongs(List<Songs> songs) {
            this.songs = songs;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("Result{");
            sb.append("songs=").append(songs);
            sb.append('}');
            return sb.toString();
        }

        public class Songs {

            private long id;
            private String name;
            private List<Artists> artists;
            private Album album;

            public long getId() {
                return id;
            }

            public void setId(long id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<Artists> getArtists() {
                return artists;
            }

            public void setArtists(List<Artists> artists) {
                this.artists = artists;
            }

            public Album getAlbum() {
                return album;
            }

            public void setAlbum(Album album) {
                this.album = album;
            }

            @Override
            public String toString() {
                final StringBuffer sb = new StringBuffer("Songs{");
                sb.append("id=").append(id);
                sb.append(", name='").append(name).append('\'');
                sb.append(", artists=").append(artists);
                sb.append(", album=").append(album);
                sb.append('}');
                return sb.toString();
            }

            public class Artists {
                private long id;
                private String name;
                private String picUrl;
                private String alias;
                private int albumSize;
                private int picId;
                private String img1v1Url;
                private int img1v1;
                private String trans;

                public long getId() {
                    return id;
                }

                public void setId(long id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getPicUrl() {
                    return picUrl;
                }

                public void setPicUrl(String picUrl) {
                    this.picUrl = picUrl;
                }

                public String getAlias() {
                    return alias;
                }

                public void setAlias(String alias) {
                    this.alias = alias;
                }

                public int getAlbumSize() {
                    return albumSize;
                }

                public void setAlbumSize(int albumSize) {
                    this.albumSize = albumSize;
                }

                public int getPicId() {
                    return picId;
                }

                public void setPicId(int picId) {
                    this.picId = picId;
                }

                public String getImg1v1Url() {
                    return img1v1Url;
                }

                public void setImg1v1Url(String img1v1Url) {
                    this.img1v1Url = img1v1Url;
                }

                public int getImg1v1() {
                    return img1v1;
                }

                public void setImg1v1(int img1v1) {
                    this.img1v1 = img1v1;
                }

                public String getTrans() {
                    return trans;
                }

                public void setTrans(String trans) {
                    this.trans = trans;
                }

                @Override
                public String toString() {
                    final StringBuffer sb = new StringBuffer("Artists{");
                    sb.append("id=").append(id);
                    sb.append(", name='").append(name).append('\'');
                    sb.append(", picUrl='").append(picUrl).append('\'');
                    sb.append(", alias='").append(alias).append('\'');
                    sb.append(", albumSize=").append(albumSize);
                    sb.append(", picId=").append(picId);
                    sb.append(", img1v1Url='").append(img1v1Url).append('\'');
                    sb.append(", img1v1=").append(img1v1);
                    sb.append(", trans='").append(trans).append('\'');
                    sb.append('}');
                    return sb.toString();
                }
            }

            public class Album {
                private long id;
                private String name;
                private Artist artist;

                public long getId() {
                    return id;
                }

                public void setId(long id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public Artist getArtist() {
                    return artist;
                }

                public void setArtist(Artist artist) {
                    this.artist = artist;
                }

                @Override
                public String toString() {
                    final StringBuffer sb = new StringBuffer("Album{");
                    sb.append("id=").append(id);
                    sb.append(", name='").append(name).append('\'');
                    sb.append(", artist=").append(artist);
                    sb.append('}');
                    return sb.toString();
                }

                public class Artist {
                    private int id;
                    private String name;
                    private String picUrl;
                    private String alias;
                    private int albumSize;
                    private int picId;
                    private String img1v1Url;
                    private int img1v1;
                    private String trans;

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getPicUrl() {
                        return picUrl;
                    }

                    public void setPicUrl(String picUrl) {
                        this.picUrl = picUrl;
                    }

                    public String getAlias() {
                        return alias;
                    }

                    public void setAlias(String alias) {
                        this.alias = alias;
                    }

                    public int getAlbumSize() {
                        return albumSize;
                    }

                    public void setAlbumSize(int albumSize) {
                        this.albumSize = albumSize;
                    }

                    public int getPicId() {
                        return picId;
                    }

                    public void setPicId(int picId) {
                        this.picId = picId;
                    }

                    public String getImg1v1Url() {
                        return img1v1Url;
                    }

                    public void setImg1v1Url(String img1v1Url) {
                        this.img1v1Url = img1v1Url;
                    }

                    public int getImg1v1() {
                        return img1v1;
                    }

                    public void setImg1v1(int img1v1) {
                        this.img1v1 = img1v1;
                    }

                    public String getTrans() {
                        return trans;
                    }

                    public void setTrans(String trans) {
                        this.trans = trans;
                    }

                    @Override
                    public String toString() {
                        final StringBuffer sb = new StringBuffer("Artist{");
                        sb.append("id=").append(id);
                        sb.append(", name='").append(name).append('\'');
                        sb.append(", picUrl='").append(picUrl).append('\'');
                        sb.append(", alias='").append(alias).append('\'');
                        sb.append(", albumSize=").append(albumSize);
                        sb.append(", picId=").append(picId);
                        sb.append(", img1v1Url='").append(img1v1Url).append('\'');
                        sb.append(", img1v1=").append(img1v1);
                        sb.append(", trans='").append(trans).append('\'');
                        sb.append('}');
                        return sb.toString();
                    }
                }
            }
        }
    }
}
