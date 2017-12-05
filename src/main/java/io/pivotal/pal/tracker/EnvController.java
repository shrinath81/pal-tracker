package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController

public class EnvController {

    private String port;
    private String memLimit;
    private String instanceId;
    private String instanceAddr;

    public EnvController(@Value("${PORT:NOT SET}") String port,
                         @Value("${MEMORY_LIMIT:NOT SET}") String memLimit,
                         @Value("${CF_INSTANCE_INDEX:NOT SET}")String instanceId,
                         @Value("${CF_INSTANCE_ADDR:NOT SET}") String instanceAddr ) {
        this.port = port;
        this.memLimit = memLimit;
        this.instanceAddr = instanceAddr;
        this.instanceId = instanceId;
    }

    @RequestMapping("/env")
    //@GetMapping
    public Map<String,String> getEnv(){

        Map envHash = new HashMap<String, String>();

        envHash.put("PORT",this.port);
        envHash.put("MEMORY_LIMIT",this.memLimit);
        envHash.put("CF_INSTANCE_INDEX",this.instanceId);
        envHash.put("CF_INSTANCE_ADDR",this.instanceAddr);

        return envHash;
    }
}
