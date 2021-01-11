package com.wyymusic.main.model;


import java.util.List;

/**
 * @author tbx
 * @date 2021/1/5
 * target:
 * time: 2021/1/5
 * God Bless my code!
 **/
public class UserResponse {

    private int loginType;
    private int code;
    private Account account;
    private String token;
    private Profile profile;
    private List<Bindings> bindings;
    private String cookie;
    private LoginErrorResponse error;

    public LoginErrorResponse getError() {
        return error;
    }

    public void setError(LoginErrorResponse error) {
        this.error = error;
    }

    public int getLoginType() {
        return loginType;
    }

    public void setLoginType(int loginType) {
        this.loginType = loginType;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public List<Bindings> getBindings() {
        return bindings;
    }

    public void setBindings(List<Bindings> bindings) {
        this.bindings = bindings;
    }

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("UserResponse{");
        sb.append("loginType=").append(loginType);
        sb.append(", code=").append(code);
        sb.append(", account=").append(account);
        sb.append(", token='").append(token).append('\'');
        sb.append(", profile=").append(profile);
        sb.append(", bindings=").append(bindings);
        sb.append(", cookie='").append(cookie).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public class Account {
        private long id;
        private String userName;
        private int type;
        private int status;
        private int whitelistAuthority;
        private long createTime;
        private String salt;
        private int tokenVersion;
        private int ban;
        private int baoyueVersion;
        private int donateVersion;
        private int vipType;
        private int viptypeVersion;
        private boolean anonimousUser;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getWhitelistAuthority() {
            return whitelistAuthority;
        }

        public void setWhitelistAuthority(int whitelistAuthority) {
            this.whitelistAuthority = whitelistAuthority;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public String getSalt() {
            return salt;
        }

        public void setSalt(String salt) {
            this.salt = salt;
        }

        public int getTokenVersion() {
            return tokenVersion;
        }

        public void setTokenVersion(int tokenVersion) {
            this.tokenVersion = tokenVersion;
        }

        public int getBan() {
            return ban;
        }

        public void setBan(int ban) {
            this.ban = ban;
        }

        public int getBaoyueVersion() {
            return baoyueVersion;
        }

        public void setBaoyueVersion(int baoyueVersion) {
            this.baoyueVersion = baoyueVersion;
        }

        public int getDonateVersion() {
            return donateVersion;
        }

        public void setDonateVersion(int donateVersion) {
            this.donateVersion = donateVersion;
        }

        public int getVipType() {
            return vipType;
        }

        public void setVipType(int vipType) {
            this.vipType = vipType;
        }

        public int getViptypeVersion() {
            return viptypeVersion;
        }

        public void setViptypeVersion(int viptypeVersion) {
            this.viptypeVersion = viptypeVersion;
        }

        public boolean isAnonimousUser() {
            return anonimousUser;
        }

        public void setAnonimousUser(boolean anonimousUser) {
            this.anonimousUser = anonimousUser;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("Account{");
            sb.append("id=").append(id);
            sb.append(", userName='").append(userName).append('\'');
            sb.append(", type=").append(type);
            sb.append(", status=").append(status);
            sb.append(", whitelistAuthority=").append(whitelistAuthority);
            sb.append(", createTime=").append(createTime);
            sb.append(", salt='").append(salt).append('\'');
            sb.append(", tokenVersion=").append(tokenVersion);
            sb.append(", ban=").append(ban);
            sb.append(", baoyueVersion=").append(baoyueVersion);
            sb.append(", donateVersion=").append(donateVersion);
            sb.append(", vipType=").append(vipType);
            sb.append(", viptypeVersion=").append(viptypeVersion);
            sb.append(", anonimousUser=").append(anonimousUser);
            sb.append('}');
            return sb.toString();
        }
    }

    public class Profile {
        private String description;
        private String remarkName;
        private boolean mutual;
        private int authStatus;
        private boolean followed;
        private String expertTags;
        private String backgroundUrl;
        private String detailDescription;
        private String avatarImgIdStr;
        private String backgroundImgIdStr;
        private int city;
        private int province;
        private String nickname;
        private int vipType;
        private int gender;
        private long backgroundImgId;
        private int userType;
        private int accountStatus;
        private boolean defaultAvatar;
        private long birthday;
        private long avatarImgId;
        private long userId;
        private String avatarUrl;
        private Experts experts;
        private int djStatus;
        private String signature;
        private int authority;
        private String avatarImgId_str;
        private int followeds;
        private int follows;
        private int eventCount;
        private String avatarDetail;
        private int playlistCount;
        private int playlistBeSubscribedCount;

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getRemarkName() {
            return remarkName;
        }

        public void setRemarkName(String remarkName) {
            this.remarkName = remarkName;
        }

        public boolean isMutual() {
            return mutual;
        }

        public void setMutual(boolean mutual) {
            this.mutual = mutual;
        }

        public int getAuthStatus() {
            return authStatus;
        }

        public void setAuthStatus(int authStatus) {
            this.authStatus = authStatus;
        }

        public boolean isFollowed() {
            return followed;
        }

        public void setFollowed(boolean followed) {
            this.followed = followed;
        }

        public String getExpertTags() {
            return expertTags;
        }

        public void setExpertTags(String expertTags) {
            this.expertTags = expertTags;
        }

        public String getBackgroundUrl() {
            return backgroundUrl;
        }

        public void setBackgroundUrl(String backgroundUrl) {
            this.backgroundUrl = backgroundUrl;
        }

        public String getDetailDescription() {
            return detailDescription;
        }

        public void setDetailDescription(String detailDescription) {
            this.detailDescription = detailDescription;
        }

        public String getAvatarImgIdStr() {
            return avatarImgIdStr;
        }

        public void setAvatarImgIdStr(String avatarImgIdStr) {
            this.avatarImgIdStr = avatarImgIdStr;
        }

        public String getBackgroundImgIdStr() {
            return backgroundImgIdStr;
        }

        public void setBackgroundImgIdStr(String backgroundImgIdStr) {
            this.backgroundImgIdStr = backgroundImgIdStr;
        }

        public int getCity() {
            return city;
        }

        public void setCity(int city) {
            this.city = city;
        }

        public int getProvince() {
            return province;
        }

        public void setProvince(int province) {
            this.province = province;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public int getVipType() {
            return vipType;
        }

        public void setVipType(int vipType) {
            this.vipType = vipType;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public long getBackgroundImgId() {
            return backgroundImgId;
        }

        public void setBackgroundImgId(long backgroundImgId) {
            this.backgroundImgId = backgroundImgId;
        }

        public int getUserType() {
            return userType;
        }

        public void setUserType(int userType) {
            this.userType = userType;
        }

        public int getAccountStatus() {
            return accountStatus;
        }

        public void setAccountStatus(int accountStatus) {
            this.accountStatus = accountStatus;
        }

        public boolean isDefaultAvatar() {
            return defaultAvatar;
        }

        public void setDefaultAvatar(boolean defaultAvatar) {
            this.defaultAvatar = defaultAvatar;
        }

        public long getBirthday() {
            return birthday;
        }

        public void setBirthday(long birthday) {
            this.birthday = birthday;
        }

        public long getAvatarImgId() {
            return avatarImgId;
        }

        public void setAvatarImgId(long avatarImgId) {
            this.avatarImgId = avatarImgId;
        }

        public long getUserId() {
            return userId;
        }

        public void setUserId(long userId) {
            this.userId = userId;
        }

        public String getAvatarUrl() {
            return avatarUrl;
        }

        public void setAvatarUrl(String avatarUrl) {
            this.avatarUrl = avatarUrl;
        }

        public Experts getExperts() {
            return experts;
        }

        public void setExperts(Experts experts) {
            this.experts = experts;
        }

        public int getDjStatus() {
            return djStatus;
        }

        public void setDjStatus(int djStatus) {
            this.djStatus = djStatus;
        }

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }

        public int getAuthority() {
            return authority;
        }

        public void setAuthority(int authority) {
            this.authority = authority;
        }

        public String getAvatarImgId_str() {
            return avatarImgId_str;
        }

        public void setAvatarImgId_str(String avatarImgId_str) {
            this.avatarImgId_str = avatarImgId_str;
        }

        public int getFolloweds() {
            return followeds;
        }

        public void setFolloweds(int followeds) {
            this.followeds = followeds;
        }

        public int getFollows() {
            return follows;
        }

        public void setFollows(int follows) {
            this.follows = follows;
        }

        public int getEventCount() {
            return eventCount;
        }

        public void setEventCount(int eventCount) {
            this.eventCount = eventCount;
        }

        public String getAvatarDetail() {
            return avatarDetail;
        }

        public void setAvatarDetail(String avatarDetail) {
            this.avatarDetail = avatarDetail;
        }

        public int getPlaylistCount() {
            return playlistCount;
        }

        public void setPlaylistCount(int playlistCount) {
            this.playlistCount = playlistCount;
        }

        public int getPlaylistBeSubscribedCount() {
            return playlistBeSubscribedCount;
        }

        public void setPlaylistBeSubscribedCount(int playlistBeSubscribedCount) {
            this.playlistBeSubscribedCount = playlistBeSubscribedCount;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("Profile{");
            sb.append("description='").append(description).append('\'');
            sb.append(", remarkName='").append(remarkName).append('\'');
            sb.append(", mutual=").append(mutual);
            sb.append(", authStatus=").append(authStatus);
            sb.append(", followed=").append(followed);
            sb.append(", expertTags='").append(expertTags).append('\'');
            sb.append(", backgroundUrl='").append(backgroundUrl).append('\'');
            sb.append(", detailDescription='").append(detailDescription).append('\'');
            sb.append(", avatarImgIdStr='").append(avatarImgIdStr).append('\'');
            sb.append(", backgroundImgIdStr='").append(backgroundImgIdStr).append('\'');
            sb.append(", city=").append(city);
            sb.append(", province=").append(province);
            sb.append(", nickname='").append(nickname).append('\'');
            sb.append(", vipType=").append(vipType);
            sb.append(", gender=").append(gender);
            sb.append(", backgroundImgId=").append(backgroundImgId);
            sb.append(", userType=").append(userType);
            sb.append(", accountStatus=").append(accountStatus);
            sb.append(", defaultAvatar=").append(defaultAvatar);
            sb.append(", birthday=").append(birthday);
            sb.append(", avatarImgId=").append(avatarImgId);
            sb.append(", userId=").append(userId);
            sb.append(", avatarUrl='").append(avatarUrl).append('\'');
            sb.append(", experts=").append(experts);
            sb.append(", djStatus=").append(djStatus);
            sb.append(", signature='").append(signature).append('\'');
            sb.append(", authority=").append(authority);
            sb.append(", avatarImgId_str='").append(avatarImgId_str).append('\'');
            sb.append(", followeds=").append(followeds);
            sb.append(", follows=").append(follows);
            sb.append(", eventCount=").append(eventCount);
            sb.append(", avatarDetail='").append(avatarDetail).append('\'');
            sb.append(", playlistCount=").append(playlistCount);
            sb.append(", playlistBeSubscribedCount=").append(playlistBeSubscribedCount);
            sb.append('}');
            return sb.toString();
        }

        private class Experts {
        }
    }

    private class Bindings {
        private long refreshTime;
        private long expiresIn;
        private String url;
        private long userId;
        private String tokenJsonStr;
        private long bindingTime;
        private boolean expired;
        private long id;
        private int type;

        public long getRefreshTime() {
            return refreshTime;
        }

        public void setRefreshTime(long refreshTime) {
            this.refreshTime = refreshTime;
        }

        public long getExpiresIn() {
            return expiresIn;
        }

        public void setExpiresIn(long expiresIn) {
            this.expiresIn = expiresIn;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public long getUserId() {
            return userId;
        }

        public void setUserId(long userId) {
            this.userId = userId;
        }

        public String getTokenJsonStr() {
            return tokenJsonStr;
        }

        public void setTokenJsonStr(String tokenJsonStr) {
            this.tokenJsonStr = tokenJsonStr;
        }

        public long getBindingTime() {
            return bindingTime;
        }

        public void setBindingTime(long bindingTime) {
            this.bindingTime = bindingTime;
        }

        public boolean isExpired() {
            return expired;
        }

        public void setExpired(boolean expired) {
            this.expired = expired;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("Bindings{");
            sb.append("refreshTime=").append(refreshTime);
            sb.append(", expiresIn=").append(expiresIn);
            sb.append(", url='").append(url).append('\'');
            sb.append(", userId=").append(userId);
            sb.append(", tokenJsonStr='").append(tokenJsonStr).append('\'');
            sb.append(", bindingTime=").append(bindingTime);
            sb.append(", expired=").append(expired);
            sb.append(", id=").append(id);
            sb.append(", type=").append(type);
            sb.append('}');
            return sb.toString();
        }
    }
}
