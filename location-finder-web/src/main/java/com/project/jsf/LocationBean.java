package com.project.jsf;

import com.maxmind.geoip.Location;
import com.maxmind.geoip.LookupService;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.apache.log4j.Logger;

@ManagedBean(name = "locationBean")
@ViewScoped
public class LocationBean implements Serializable{

    private FacesContext context = null;
    private ExternalContext externalContext = null;

    private static final Logger LOGGER = Logger.getLogger(LocationBean.class);
    private String ip;

    public LocationBean() {

    }

    public void doSearch(){
        this.getLocation();
    }
    
    public LocationDTO getLocation() {        
        ////// ola laaaaa
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();                           
        context = FacesContext.getCurrentInstance();
        externalContext = context.getExternalContext();
        String path = externalContext.getRealPath("/WEB-INF/GeoLiteCity.dat");
        LOGGER.info("GeoLiteCity file path is  " + path);      
        File file = new File(path);      
        if (ip == null) {
           ip = "82.199.221.132";          
        }
        //-Djava.net.preferIPv4Stack=true
        if (ip.equalsIgnoreCase("0:0:0:0:0:0:0:1")) {
            ip = "82.199.221.132";
        }
        if (ip.equalsIgnoreCase("127.0.0.1")) {
            ip = "82.199.221.132";
            
        }
        LOGGER.info("IP PASSED " + ip);
        return getLocation(ip, file);
    }

    private LocationDTO getLocation(String ipAddress, File file) {
        LocationDTO locationModel = new LocationDTO();
        try {
            LookupService lookup = new LookupService(file, LookupService.GEOIP_MEMORY_CACHE);
            Location locationServices = lookup.getLocation(ipAddress);
            if (locationServices != null) {
                if (locationServices.city != null) {
                    locationModel.setCity(locationServices.city);
                }
                if (locationServices.countryName != null) {
                    locationModel.setCountryName(locationServices.countryName);
                }
                if (locationServices.countryCode != null) {
                    locationModel.setCountryCode(locationServices.countryCode);
                }
                if (locationServices.latitude != 0) {
                    locationModel.setLatitude(Double.valueOf(locationServices.latitude));
                }
                if (locationServices.longitude != 0) {
                    locationModel.setLongitude(Double.valueOf(locationServices.longitude));
                }
            }
        } catch (IOException e) {
            LOGGER.info(e.getMessage());
        }
        return locationModel;

    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
    
    
}
