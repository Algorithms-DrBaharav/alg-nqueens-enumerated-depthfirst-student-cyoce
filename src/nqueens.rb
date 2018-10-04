def main()
    $n = ARGV[0].to_i || 8
    solve.each do |b|
        printboard b
        puts
    end
end

def solve
    Enumerator.new do |e|
        [*0..$n-1].permutation do |a|
            e.yield a if board_valid?(a)
        end
    end
end

def board_valid?(a)
    (0..$n-1).each do |i|
        (i+1..$n-1).each do |j|
            return false if (a[i] - a[j]).abs == j - i
        end
    end
    true
end

def printboard b
    b.each do |a|
        expand2d(a).each do |x|
            print (x == 1 ? ?@ : ?+)
            print ' '
        end
        puts
    end
end

def expand2d(n)
    Array.new($n){ |i| i == n ? 1 : 0 }
end

main() if __FILE__ == $0
