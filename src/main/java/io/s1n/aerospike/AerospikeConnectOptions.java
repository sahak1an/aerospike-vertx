package io.s1n.aerospike;

import com.aerospike.client.async.EventPolicy;
import com.aerospike.client.async.NettyEventLoops;
import com.aerospike.client.policy.ClientPolicy;
import com.aerospike.client.policy.Replica;
import io.netty.channel.nio.NioEventLoopGroup;

public class AerospikeConnectOptions {

  static final int DEFAULT_EVENT_LOOP_SIZE = 2 * Runtime.getRuntime().availableProcessors() - 1;
  static final int DEFAULT_MAX_COMMANDS_IN_PROCESS = 128;
  static final int MAX_CONNS_PER_NODE = DEFAULT_MAX_COMMANDS_IN_PROCESS * DEFAULT_EVENT_LOOP_SIZE;
  static final int DEFAULT_MAX_CONNECT_RETRIES = 5;

  private String host;
  private int port;
  private int maxConnsPerNode;
  private int eventLoopSize;
  private int maxCommandsInProcess;
  private int maxCommandsInQueue;
  private ClientPolicy clientPolicy;
  private int maxConnectRetries;

  public AerospikeConnectOptions() {
    ClientPolicy clientPolicy = new ClientPolicy();
    clientPolicy.readPolicyDefault.replica = Replica.MASTER_PROLES;
    this.clientPolicy = clientPolicy;
    this.maxConnsPerNode = MAX_CONNS_PER_NODE;
    this.eventLoopSize = DEFAULT_EVENT_LOOP_SIZE;
    this.maxCommandsInProcess = DEFAULT_MAX_COMMANDS_IN_PROCESS;
    this.maxConnectRetries = DEFAULT_MAX_CONNECT_RETRIES;
  }

  public AerospikeConnectOptions setMaxConnectRetries(int maxConnectRetries) {
    this.maxConnectRetries = maxConnectRetries;
    return this;
  }

  public AerospikeConnectOptions setClientPolicy(ClientPolicy clientPolicy) {
    this.clientPolicy = clientPolicy;
    return this;
  }

  public AerospikeConnectOptions setHost(String host) {
    this.host = host;
    return this;
  }

  public AerospikeConnectOptions setPort(int port) {
    this.port = port;
    return this;
  }

  public AerospikeConnectOptions setMaxConnsPerNode(int maxConnsPerNode) {
    this.maxConnsPerNode = maxConnsPerNode;
    return this;
  }

  public AerospikeConnectOptions setEventLoopSize(int eventLoopSize) {
    this.eventLoopSize = eventLoopSize;
    return this;
  }

  public AerospikeConnectOptions setMaxCommandsInProcess(int maxCommandsInProcess) {
    this.maxCommandsInProcess = maxCommandsInProcess;
    return this;
  }

  public AerospikeConnectOptions setMaxCommandsInQueue(int maxCommandsInQueue) {
    this.maxCommandsInQueue = maxCommandsInQueue;
    return this;
  }

  public AerospikeConnectOptions updateClientPolicy() {
    EventPolicy eventPolicy = new EventPolicy();
    eventPolicy.maxCommandsInProcess = this.getMaxCommandsInProcess();
    eventPolicy.maxCommandsInQueue = this.getMaxCommandsInQueue();
    this.clientPolicy.eventLoops = new NettyEventLoops(eventPolicy,
        new NioEventLoopGroup(this.getEventLoopSize()));
    this.clientPolicy.maxConnsPerNode = this.getMaxConnsPerNode();
    return this;
  }

  public String getHost() {
    return host;
  }

  public int getPort() {
    return port;
  }

  public int getMaxConnsPerNode() {
    return maxConnsPerNode;
  }

  public int getEventLoopSize() {
    return eventLoopSize;
  }

  public int getMaxCommandsInProcess() {
    return maxCommandsInProcess;
  }

  public int getMaxCommandsInQueue() {
    return maxCommandsInQueue;
  }

  public ClientPolicy getClientPolicy() {
    return clientPolicy;
  }

  public int getMaxConnectRetries() {
    return maxConnectRetries;
  }
}
