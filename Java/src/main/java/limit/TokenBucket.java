package limit;


/**
 * 令牌桶的工作过程：
 * 1.令牌根据时间匀速的产生令牌数量，这里假设是r，存入到令牌桶中.
 * <p>
 * 2.令牌桶在初始化的时候，会分配一定数量的令牌数capicity。
 * <p>
 * 3.消息到来之后，会从令牌桶里面取出令牌消费掉，这里假设是d，如果获取不到令牌的话，就直接触发限速保护策略，往往是直接丢弃。
 * <p>
 * 当前时间t内可以消费的令牌数量为：
 * <p>
 * 当前令牌桶剩余的令牌数(这里最大是capicity) + r*t
 */

/**
 * permitsPerSecond：每秒产生的令牌数；
 * <p>
 * <p>
 * maxBurstSeconds：  桶中最多可以保存多少秒存入的令牌数
 * <p>
 * <p>
 * maxPermits：最大令牌数 等于permitsPerSecond*maxBurstSeconds
 * <p>
 * <p>
 * stableIntervalMicros：产生一个令牌所需的微秒数
 * <p>
 * <p>
 * storedPermits：当前已存储的令牌数；
 * <p>
 * <p>
 * **nextFreeTicketMicros：核心参数，表示下一个可以分配令牌的时间点；**可以是过去也可以是将来的时间点
 */
public class TokenBucket {
}
