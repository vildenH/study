package main

import (
	"context"
	"fmt"
	"time"
)

//context 解决goroutine中的元数据传递 和退出通知

func main() {
	ctx, cancel := context.WithTimeout(context.Background(), 1*time.Second)
	defer cancel()
	go handle(ctx, 1500*time.Millisecond)
	select {
	case <-ctx.Done():
		fmt.Println("main", ctx.Err())
	}

}

func handle(ctx context.Context, duration time.Duration) {
	select {
	case <-ctx.Done():
		fmt.Println("handle", ctx.Err())
		return
	case <-time.After(duration):
		fmt.Println("process request with", duration)

	}
}
